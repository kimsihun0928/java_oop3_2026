package io.ch16;

import java.io.FileReader;
import java.io.FileWriter;

public class FileStreamBasic {

    public static void main(String[] args) {
        writeToFile("basic_output.txt");
        System.out.println("------------------");
        readFromFile("basic_output.txt");

    } // end of main

    // 파일에 텍스트를 쓰는 메서드 (문자 기반 스트림 사용)
    public static void writeToFile(String fileName) {
        /**
         * FileWriter 는 문자 기반 출력 스트림이다.
         * FileOutputStream 의 fos.write(byte[]) 와 달리 write(String) 이 가능
         * getBytes() 변환이 필요 없음
         */

        // append 모드를 설정하지 않으면 기본값이 false (덮어쓰기)
        try (FileWriter writer = new FileWriter(fileName, false)) {
            String text = "자바 문자 기반 스트림 예제\n";
            // text.getBytes() 할 필요없이
            writer.write(text);
            writer.write("추가 문자열을 기록 합니다.");
            // writer.flush(); 생략 가능
            System.out.println("파일에 텍스트를 잘 기록 하였습니다.");

        } catch (Exception e) {
            System.err.println("파일 쓰기 중 오류 발생 : " + e.getMessage());
        }
    }

    public static void readFromFile(String fileName) {
        /**
         * FileReader 는 문자 기반 입력 스트림
         * read() 는 한 문자씩 읽어 유니코드 값(정수) 으로 반환
         * FileInputStream 과 사용법은 같지만 한글이 깨지지 않음
         */

        try (FileReader reader = new FileReader(fileName)) {

            int charCode;
            while ((charCode = reader.read()) != -1 ) {
                System.out.print((char) charCode);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

} // end of class
