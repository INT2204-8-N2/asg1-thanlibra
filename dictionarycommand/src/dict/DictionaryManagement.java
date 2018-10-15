/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dict;

/**
 *
 * @author Minh Anh
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.io.FileWriter;
class DictionaryManagement{
    Dictionary dic = new Dictionary();
        //hàm nhập từ bàn phím
    public void insertFromCommandline() {
        Scanner cin = new Scanner(System.in);
        System.out.print("How many words: ");
        int n = cin.nextInt();
        cin.nextLine();
        for (int i = 0; i < n; i++) {
            Word wo = new Word();
            System.out.print((i + 1) + " Tiếng Anh: ");
            wo.spelling = cin.nextLine();
            System.out.print("Nghĩa Tiếng Việt: ");
            wo.explain = cin.nextLine();
            dic.words.put(wo.spelling,wo.explain);
        }
    }
// ham in ra man hinh toan bo cac tu
    public void showallword(){
        System.out.println("No"+"\t\t\t"+ "Tiếng Anh"+ "\t\t\t"+"Tiếng Việt");
        final int[] k = {0};
        Set<String> keySet= dic.words.keySet();
        for(String i: keySet) {
            System.out.print(k[0]);
            k[0]++;
            System.out.print( "\t\t|"+ i + " : \t\t\t|" + dic.words.get(i)+"\n");
        }
    }
    //ham nhap tu file
    public void insertfromFile(){
        File file = new File("dictionaries.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            int i = 0;
            String line = "";
            for (i = 0; (line = br.readLine()) != null; i++){
                Word ex = new Word();
                String[] a = line.split("\\s", 2);
                ex.spelling = a[0];
                ex.explain = a[1];
                dic.words.put(ex.spelling,ex.explain);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int dictionaryLookup(String Eng){
         Eng = Eng.toLowerCase();
        Set<String> keySet= dic.words.keySet();
        for(String i: keySet) {
            if(i.equals(Eng)==true) {
                System.out.print( "|"+i + " : \t\t\t|" + dic.words.get(i) + "\n");
                return 1;
            }
        }
        System.out.println("không tìm thấy");
        return 0;
    }
    public void insertWords(String Eng, String mean){
        Word newword = new Word();
        this.insertfromFile();
        newword.spelling= Eng.toLowerCase();
        newword.explain= mean.toLowerCase();
        dic.words.put(newword.spelling,newword.explain);
        this.dictionaryExportToFile();
    }
    //xóa từ
    public int  deleteWords(String Eng){
        Eng = Eng.toLowerCase();
       Set<String> keySet= dic.words.keySet();
        int kt=0;
        for(String i: keySet) {
            if(i.equals(Eng)==true) {
                dic.words.remove(Eng);
                kt = 1;
                break;
            }
        }
        this.dictionaryExportToFile();
        if(kt==0) {
            System.out.println("không tìm thấy rừ để xóa");
            return 0;
        }
        else {
            System.out.println("xóa thành công");
            return 1;
        }
    }
    //sửa từ
    public int ModifyWord(String sEng, String Eng, String mean){
         sEng = sEng.toLowerCase();
        Set<String> keySet= dic.words.keySet();
        int kt=0;
        for(String i: keySet) {
            if(i.equals(sEng)==true) {
                dic.words.remove(sEng);
                sEng=Eng.toLowerCase();
                mean =mean.toLowerCase();
                dic.words.put(Eng,mean);
                kt = 1;
                break;
            }
        }
        this.dictionaryExportToFile();
        if(kt==0) {
            System.out.println("không tìm thấy từ cần sửa");
            return 0;
        }
        else {
            System.out.println("Sửa thành công");
            return 1;
        }
    }
    public int dictionarySearcher(String w){  
        //System.out.println("Find :");
        Scanner scan= new Scanner(System.in);
        w=w.toLowerCase();
        Set<String> keySet= dic.words.keySet();
        int kt=0;
        for(String i: keySet) {
            if(w.length()<=i.length()){
                String a=i.toLowerCase().substring(0,w.length());
                if(a.equals(w)) {
                    System.out.println(i + " \t|" + dic.words.get(i));
                    kt=1;
                }
            }
        }
        if(kt==0) return 0;
        else return 1;
    }
    public void dictionaryExportToFile(){
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File f = new File("output.txt");
            FileWriter fw = new FileWriter(f);
            Set<String> keySet= dic.words.keySet();
            fw.write("\r\n");
            for(String i: keySet) {
                //Bước 2: Ghi dữ liệu
                String s= i+" "+ dic.words.get(i)+"\r\n";
                fw.write(s);                
            }
            //Bước 3: Đóng luồng
            fw.close();
        } catch (IOException ex) {
            System.out.println("Can't write to file " + ex);
        }
    }
}
