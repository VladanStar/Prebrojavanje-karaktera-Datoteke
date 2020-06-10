package com.company;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args)throws IOException{
        new Main();
    }
    public Main()throws IOException{
        File file = new File("text.txt");
        FileUtil fu = new FileUtil(file);
        fu.writenFile("Hello world");
        fu.replaceUpperLowerCase();
        System.out.println(fu.readFromFile());
        System.out.println(fu.countCharacter());
    }
}
