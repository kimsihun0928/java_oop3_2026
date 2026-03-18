package io.ch17_1.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==== To-Do List ====");
        System.out.println("1. 할 일 추가");
        System.out.println("2. 전체 목록 보기");
        System.out.println("3. 완료 처리");
        System.out.println("4. 미완성 목록만 보기");
        System.out.println("5. 완료 취소"); // [V] 자바 --> [ ] 자바
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            addTask(sc);
        } else if (choice.equals("2")) {
            showAll();
        } else if (choice.equals("3")) {
            successTask(sc);
        } else if (choice.equals("4")) {
            searchNone();
        } else if (choice.equals("5")) {
            cancelTask(sc);
        }
        sc.close();


    } // end of main

    private static void showAll() {
        System.out.println("=== ToDoList 전체 목록 === ");
        try (BufferedReader br = new BufferedReader(new FileReader("todo.txt"));) {
            int count = 0;
            String line;
            while ((line = br.readLine()) != null) {
                count++;
                System.out.println(count + "번 : " + line);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static void addTask(Scanner sc) {
        System.out.print("추가할 할 일을 입력하세요 : ");
        String task = sc.nextLine();

        // "[ ] 할 일 내용" 형식으로 지정
        // [ ] 미완료 상태

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("todo.txt", true))) {
            bw.write("[ ]" + task);
            bw.newLine();
            System.out.println("추가됐습니다 : " + task);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void successTask(Scanner sc) {
        System.out.println("완료할 할 일을 정확히 입력해주세요");
        String task = sc.nextLine();
        String tempList;
        boolean flag = false;
        ArrayList<String> line = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("todo.txt"))) {
            while ((tempList = br.readLine()) != null) {
                if (tempList.contains(task)) {
                    line.add(tempList.replace("[ ]", "[V]"));
                    flag = true;
                } else {
                    line.add(tempList);
                }
            }
            if (flag == false) {
                System.out.println("목록에 업무가 존재하지 않습니다.");
                return;
            } else {
                System.out.println("완료 처리 되었습니다 ");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("todo.txt"))) {
            for (String updateList : line) {
                bw.write(updateList);
                bw.newLine();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void searchNone() {
        System.out.println("미완료 목록 입니다");
        try (BufferedReader br = new BufferedReader(new FileReader("todo.txt"))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("[V]")) {
                    System.out.println(line);
                    count++;
                }
            }

            if (count == 0) {
                System.out.println("미완료 목록 입니다");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void cancelTask(Scanner sc) {
        System.out.println("취소할 할 일을 정확히 입력해주세요");
        String task = sc.nextLine();
        String tempList;
        boolean flag = false;
        ArrayList<String> line = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("todo.txt"))) {
            while ((tempList = br.readLine()) != null) {
                if (tempList.contains(task)) {
                    line.add(tempList.replace("[V]", "[ ]"));
                    flag = true;
                } else {
                    line.add(tempList);
                }
            }
            if (flag == false) {
                System.out.println("목록에 업무가 존재하지 않습니다.");
                return;
            } else {
                System.out.println("취소 처리 되었습니다 ");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("todo.txt"))) {
            for (String updateList : line) {
                bw.write(updateList);
                bw.newLine();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

} // end of class