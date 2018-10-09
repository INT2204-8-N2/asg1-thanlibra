/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dict;

/**
 *
 * @author Lai Thi Thu Phuong
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

/**
 *
 * @author Lai Thi Thu Phuong
 */
public class javaconnect {
    Dictionary newdict= new Dictionary();
    Dictionary lsdict = new Dictionary();
    //ket noi sql
    private Connection connect() {
        Connection conn=null;
        String url = "jdbc:sqlite:dictionaries.db";
      conn = null;
        try {
            
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    //hàm in ra tất cả các từ
   public void selectAll(){
        String sql = "SELECT idx, word, detail FROM tbl_edict";        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                System.out.println(rs.getInt("idx") +  "\t" + 
                                   rs.getString("word") + "\t" +
                                   rs.getString("detail"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   //hàm ghi từ ra file txt
    public void dictionaryExportToFile(String filename){
        try {
            
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            Set<String> keySet= newdict.words.keySet();
            fw.write("\r\n");
            for(String i: keySet) {
                //Bước 2: Ghi dữ liệu
                String s= i+" "+ newdict.words.get(i)+"\r\n";
                fw.write(s);                
            }
           
            fw.close();
        } catch (IOException ex) {
            System.out.println("Can't write to file " + ex);
        }
    }
   //hàm chèn từ
    public int insert(String word, String detail) {
        String sql = "INSERT INTO tbl_edict(word,detail) VALUES(?,?)";
        try (Connection conn = this.connect();PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if(this.find(word)==" "){   
                pstmt.setString(1, word);
                pstmt.setString(2, detail);
                pstmt.executeUpdate();
                return 1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    //hàm sua từ
    public int update(String sword, String word, String detail) {
        if(this.delete(sword)==1){
            this.insert(word, detail);
            return 1;
        }
        return 0;
    }
    //hàm xóa từ
    public int delete(String word) {
        String sql = "DELETE FROM tbl_edict WHERE word = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if(this.find(word)!=" "){           
                pstmt.setString(1, word);            
                pstmt.executeUpdate();                
            }
            else return 2;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return 1;
    }
    //hàm tìm kiếm từ
    public String find(String word) {
        String sql = "SELECT idx, word, detail FROM tbl_edict"; 
        lsdict.words.put(word, "");
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                if(word.equals(rs.getString("word"))==true){
                String s=rs.getString("detail");
                return s;}
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return " ";
    }
    //hàm tìm kiếm tương đối
    public int findtd(String word) {
        String sql = "SELECT idx, word, detail FROM tbl_edict";
        lsdict.words.put(word, "");
        word=word.toLowerCase();
        int i=0;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                if(word.length()<=rs.getString("word").length()){
                    String a= rs.getString("word").substring(0,word.length());
                    if(a.equals(word)){
                        i++;
                        String m= Integer.toString(i);
                        newdict.words.put(rs.getString("word"),m);
                    }
                }               
            }
            this.dictionaryExportToFile("newdic.txt");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(i!=0) return 1;
        else return 0;
    }
    public static void main(String[] args) {
    }
}
