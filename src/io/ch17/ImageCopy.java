package io.ch17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopy {

    public static void main(String[] args) {
        // bubble.png 파일을 읽어서
        // bubble2.png 파일을 만들어보세요 (복사 기능)

        long start = System.currentTimeMillis();

        try (FileInputStream fis = new FileInputStream("beach.jpg");
             FileOutputStream fos = new FileOutputStream("C:\\_work_java\\beach3.png")) {
            // 역슬래쉬 \\ 말고도 / 해도 가능은 하지만 리눅스 서버에서는 \\ 사용

            int charCode;
            while ((charCode = fis.read()) != -1) {
                fos.write(charCode);
            }
            long end = System.currentTimeMillis();
            System.out.println((end - start));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


} // end of main

