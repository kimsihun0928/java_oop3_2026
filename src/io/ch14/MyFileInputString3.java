package io.ch14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileInputString3 {

    public static void main(String[] args) {

//        try {
//            FileInputStream in = new FileInputStream("a_.txt");
//
//            int readData;
//            while ((readData = in.read()) != -1) {
//                System.out.print((char) readData);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // 시나리오 1
        FileInputStream in = null;
        try {
            in = new FileInputStream("a.txt");
            int readData;
            readData = in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
