package io.ch15_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ScoreRecord {

    public static void main(String[] args) {
        // 1. 파일에 성적 입력
        Scanner sc = new Scanner(System.in);
        saveScore(sc);
        avgScore();


    } // end of main

    private static void avgScore() {
        try (FileInputStream fis = new FileInputStream("student_score.txt")) {
            int score;
            String stringScore = "";
            while ((score = fis.read()) != -1) {
                stringScore += (char) score;
            }
            System.out.println(stringScore);
            StringTokenizer stn = new StringTokenizer(stringScore);
            int a = Integer.parseInt(stn.nextToken());
            int b = Integer.parseInt(stn.nextToken());
            int c = Integer.parseInt(stn.nextToken());
            int d = Integer.parseInt(stn.nextToken());
            int e = Integer.parseInt(stn.nextToken());

            double avgNum = (a + b + c + d + e) / 5.0;
            System.out.printf("평균 점수 : %.2f", avgNum);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    private static void saveScore(Scanner sc) {
        System.out.print("성적을 입력하세요 : ");
        String score = sc.nextLine();
        try (FileOutputStream fos = new FileOutputStream("student_score.txt")) {
            fos.write(score.getBytes());
            fos.write("\n".getBytes());
            System.out.println("저장 완료");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

} // end of class
