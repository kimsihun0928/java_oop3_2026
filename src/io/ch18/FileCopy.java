package io.ch18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    public static void main(String[] args) {

        // 파일 경로 지정
        String sourceFilePath = "employees.zip"; // 원본 데이터
        String destinationFilePath = "employees_copy.zip"; // 복사되어 만들어질 데이터

        // 소요시간 측정 시작
        // 현재 시각을 나노 초(10억분의 1초) 단위로 변환 1970~
        long startTime = System.nanoTime();

        //....


        // 파일 복사 기능
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath)) {

            // employees.zip 에서 1 바이트씩 읽어서
            // employees_copy.zip 에 1바이트씩 쓰기
            int data; // fis.read() 한 순간 1바이트를 읽는거기 때문에 while 조건식에서 읽고 바디에서 대입할때의 fis.read() 값은 다름
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("파일 복사 완료");


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double seconds = duration / 1_000_000_000.0; // 나노 초 --> 초 변환
        System.out.println("나노 초 값 : " + duration);
        System.out.println("초(seconds) 값 : " + seconds);

    } // end of main
} // end of class
