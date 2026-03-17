package io.ch15_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class SecretNote {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("=== 비밀 메모장 ===");
        System.out.println("1. 메모 암호화 저장");
        System.out.println("2. 메모 복호화 읽기");
        System.out.print("선택 : ");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            saveMemo(sc);
        } else if (choice.equals("2")) {
            readMemo(sc);
        }


    } // end of main

    private static void readMemo(Scanner sc) {
        // 3. 파일에서 데이터를 한 바이트씩 읽어야한다
        // 3.1 한 바이트를 읽을 때 마다 아스키코드 값 기준 -3 씩 해서 암호를 해석한다.
        System.out.print("복호화 키 : ");
        int key = sc.nextInt();

        System.out.println("\n === 복호화된 메모 ===");
        System.out.print("복호화 결과 : ");

        int data;
        try (FileInputStream fis = new FileInputStream("secret.txt")) {

            // 한 바이트씩 개수만큼 읽어서 콘솔에 출력 - 암호도 풀어서
            while ((data = fis.read()) != -1) {
                System.out.print((char) (data - key));
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static void saveMemo(Scanner sc) {

        System.out.print("저장할 메모를 입력하세요. : ");
        String input = sc.nextLine();
        System.out.print("암호화 키 : ");
        int key = sc.nextInt();
        // String key = sc.nextLine(); 으로 하고 Integer.parseInt(key) 를 해야하는 이유?

        try (FileOutputStream fos = new FileOutputStream("secret.txt")) {
            byte[] original = input.getBytes(); // [65][66][67]
            // 배열의 크기만 선언한 상태
            byte[] encrypted = new byte[original.length]; // [65+3] [66+3] [67+3]

            for (int i = 0; i < original.length; i++) {
                encrypted[i] = (byte) (original[i] + key);
            }

            // 데이터를 암호화한 후 파일에 쓰기
            fos.write(encrypted);
            // fos.flush(); --> fos.close() 호출 시 자동 호출

            System.out.println("저장 완료! (각 문자에 " + key + "를 더해서 저장)");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

} // end of class
