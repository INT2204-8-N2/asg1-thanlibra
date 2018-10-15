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
import java.util.Scanner;
public class DictionaryCommandline {
    public void dictionaryBasic(){
       DictionaryManagement dm= new DictionaryManagement();
       dm.insertFromCommandline();
       dm.showallword();
    }
    public void dictionaryAdvanced(){
        DictionaryManagement dm= new DictionaryManagement();
        Scanner cin= new Scanner(System.in);
        dm.insertfromFile();
        dm.showallword();
        System.out.print("nhập từ cần tìm: ");
        String Eng= cin.nextLine().toLowerCase();
        dm.dictionaryLookup(Eng);
    }
    public static void main(String[] args) {
        DictionaryCommandline dc= new DictionaryCommandline();
        //dc.dictionaryBasic();
        //dc.dictionaryAdvanced();
        DictionaryManagement dm= new DictionaryManagement();
        //thêm từ
        dm.insertfromFile();
        Scanner cin= new Scanner(System.in);
        System.out.println("nhập từ muốn thêm: ");
        String Eng = cin.nextLine().toLowerCase();
        System.out.println("Nghĩa: ");
        String mean1= cin.nextLine().toLowerCase();
        if(dm.dictionaryLookup(Eng)==1){
            System.out.println("từ đã có sẵn");
        }
        else {
            dm.insertWords(Eng, mean1);
            System.out.println("thêm thành công");
        }
        //xóa từ trong file
        System.out.print("nhập từ cần xóa: ");
        String dEng= cin.nextLine().toLowerCase();
        dm.deleteWords(dEng);
        //sửa từ trong file
        System.out.print("Nhập từ muốn sửa: ");
        String sword= cin.nextLine().toLowerCase();
        System.out.println("sửa thành: ");
        String word= cin.nextLine().toLowerCase();
        System.out.println("nghĩa: ");
        String mean= cin.nextLine().toLowerCase();
        dm.ModifyWord(sword, word, mean);
        //tìm tương đối
        System.out.println("Nhập tìm tương đối: ");
        String w= cin.nextLine().toLowerCase();
        dm.dictionarySearcher(w);
    }
}
