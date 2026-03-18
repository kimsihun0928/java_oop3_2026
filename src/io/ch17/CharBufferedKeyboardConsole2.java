package io.ch17;

import java.io.*;

public class CharBufferedKeyboardConsole2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write("??? : " + line);
            bw.newLine();
            bw.flush();
        }


    } // end of main

}
