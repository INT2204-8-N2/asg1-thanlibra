/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dict;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author Minh Anh
 */
public class lichsutim {
    Dictionary lsdic = new Dictionary();
    public void insert(){
        File file = new File("lsdic.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            int i = 0;
            String line = "";
            for (i = 0; (line = br.readLine()) != null; i++){
                String[] a = line.split("\\s", 2);
               lsdic.words.put(a[0], a[1]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }              
    }
    public void write(){
        try {           
            File f = new File("lsdic.txt");
            FileWriter fw = new FileWriter(f);          
            Set<String> keySet= lsdic.words.keySet();
            fw.write("\r\n");
            for(String i: keySet) {               
                String s= i+" "+ lsdic.words.get(i)+"\r\n";
                fw.write(s);                
            }          
            fw.close();
        } catch (IOException ex) {
            System.out.println("Can't write to file " + ex);
        }
    }
    public void luutu(String word){
        this.insert();
        lsdic.words.put(word, "");
        this.write();
    }
    public void xoatu(String word){
        this.insert();
        lsdic.words.remove(word);
        this.write();
    }
}
