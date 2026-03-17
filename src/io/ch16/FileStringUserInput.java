package io.ch16;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;

public class FileStringUserInput {

    public static void main(String[] args) {
        writeUserInputToFile("user_input.txt");
        readFromFile("user_input.txt");


    } // end of main

    public static void writeUserInputToFile(String fileName) {
        /**
         * 키보드 입력 -> InputStreamReader(System.in) (바이트 -> 문자 변환)
         * 파일에 쓰기 -> FileWriter(fileName)         (문자 기반 파일 출력)
         */

        try (InputStreamReader reader = new InputStreamReader(System.in);
             FileWriter writer = new FileWriter(fileName, true)) {

            System.out.println("텍스트를 입력하세요 (종료 : Ctrl + D");
            // 1. 사용자가 입력한 값을 받자 - 키보드에서
            int charCode;
            while ((charCode = reader.read()) != -1) {
                writer.write(charCode);
                // 문자 하나 받을 때마다 즉식 파일에 저장
                writer.flush();
            }
            System.out.println("텍스트 모드 작성");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // 직접 코드 작성해보기
    // 파일에서 텍스트를 읽는 메서드를 직접 구현해보세요
    public static void readFromFile(String fileName) {
        // ... 파일의 내용을 문자 기반으로 읽어서 콘솔 창에 출력
        try (FileReader reader = new FileReader(fileName)) {
            int charCode;
            while ((charCode = reader.read()) != -1 ) {
                System.out.print((char) charCode);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
