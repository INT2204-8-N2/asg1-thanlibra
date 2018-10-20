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
    
    //ket noi sql
    private Connection connect() {
        Connection conn=null;
        String url = "jdbc:sqlite:dictionaries1.db";
      conn = null;
        try {
            
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
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
    public int insert(String word, String info) {
        String sql = "INSERT INTO Dictionary(word,info) VALUES(?,?)";
        try (Connection conn = this.connect();PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if(this.find(word)=="khong tim thay"){   
                pstmt.setString(1, word);
                pstmt.setString(2, info);
                pstmt.executeUpdate();
                return 1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    //hàm sua từ
    public int update(String sword, String word, String info) {
        String Eng = sword;
        String mean= this.find(Eng);
        if(this.delete(sword)==1){
            if(this.insert(word, info)==1) return 1;
            else {
                this.insert(Eng, mean);
                return 2;
            }
        }
        //tra ve 0 khi khong tim thay tu can sua
        return 0;
    }
    //hàm xóa từ
    public int delete(String word) {
        String sql = "DELETE FROM Dictionary WHERE word = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if(this.find(word)!="khong tim thay"){           
                pstmt.setString(1, word);            
                pstmt.executeUpdate();                
            }
            else return 2;// tra ve 2 khi khong tim thay tu can xoa
        } catch (SQLException e) {
            //ket noi khong thanh cong voi database
            System.out.println(e.getMessage());
            return 0;
        }
        //tra ve 1 khi tim thay va xoa thanh cong
        return 1;
    }
    //hàm tìm kiếm từ
    public String find(String word) {
       String sql = "SELECT id, word, info FROM Dictionary Where word=?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){            
            // set the value
            pstmt.setString(1, word);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                String s=rs.getString("info");
                //tra ve nghia cua tu can tim
                return s;}          
        } catch (SQLException e) {
            //ket noi database khong thanh cong, in ra loi
            System.out.println(e.getMessage());
        }
        //tra ve "khong tim thay " khi khonng tim thay tu can tim
        return "khong tim thay";
    }
    //hàm tìm kiếm tương đối
    public int findtd(String word) {
        String sql = "SELECT id, word, info FROM Dictionary WHERE word like '"+word+"%'";       
        int i=0;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {                
                i++;//tang i khi co tu tuong dong
                newdict.words.put(rs.getString("word"),"");//put tu vao mang                              
            }
            this.dictionaryExportToFile("newdic.txt");// put mang tu vao file txt de luu tru           
        } catch (SQLException e) {
            //ket noi database khong thanh cong
            System.out.println(e.getMessage());
        }
        if(i!=0) return 1;//tra ve 1 khi so tu tuong dong khac 0
        else return 0;//tra ve 0 khi khong co tu nao tuong dong
    }
    public static void main(String[] args) {
    }
}
