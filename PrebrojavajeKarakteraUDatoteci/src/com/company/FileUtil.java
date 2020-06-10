package com.company;

import java.io.*;

public class FileUtil {
    private File file;
    private BufferedReader br;
    private BufferedWriter bw;

    // konstruktor koji prima parametar file nad kojim ce se vrsiti metode

    public FileUtil(File file) throws IOException{
        this.bw = new BufferedWriter(new FileWriter(file));
        this.br = new BufferedReader(new FileReader(file));
        this.file = file;
    }
    // prima kao parametar string koji treba upisati u datoteku
    public void writenFile(String text) throws IOException{
        bw.write(text);
        bw.flush();
    }
    // cita sav sadrzaj iz datoteke i vraca ga kao string
    public String readFromFile()throws IOException {
        String line = null;
        String result = "";
        while((line = br.readLine()) !=null){
            result +=line + "\r\n";
        }
        resetReader();
        return result;
    }
    // cita prvih n karaktera iz datoteke
    public String readCharacters(int n) throws IOException {
        br.mark(n);
        int r = 0;
        char tmpChr = 0;
        String result = "";

        while(r<n){
            tmpChr = (char) br.read();
            result +=tmpChr;
            r++;
        }
        br.reset();
        return  result;
    }
    public void resetReader()throws IOException{
        br = new BufferedReader(new FileReader(file));
    }
    public  void setFile(File file){
        this.file = file;
    }
    public int countCharacter() throws IOException{
        int charCount =0;
        while(br.read()>-1){
            charCount++;
        }
        resetReader();
        return charCount;
    }
    // zamenjuje mala slova velikim i obrnuto
    public void replaceUpperLowerCase()throws  IOException{
        String original = readFromFile();
        String result = "\r\n" + upperLowerStrReplace(original);
    }

    private String upperLowerStrReplace(String str) {
        for(int i = 0; i<str.length(); i++){
            char tmpChar = str.charAt(i);
            if(Character.isUpperCase(tmpChar)){
                tmpChar = Character.toLowerCase(tmpChar);
            }
            else if(Character.isLowerCase(tmpChar)){
                tmpChar = Character.toUpperCase(tmpChar);
            }
            str = str.substring(0,i) + tmpChar + str.substring( i+1);
        }
        return str;
    }
}

