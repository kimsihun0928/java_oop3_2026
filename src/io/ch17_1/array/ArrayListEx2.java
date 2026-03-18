package io.ch17_1.array;

import java.util.ArrayList;

public class ArrayListEx2 {

    public static void main(String[] args) {
        // 정수, 실수, 불리언, 사용자 정의 객체를 담을 수 있는  ArrayList 각각 만들어서 사용해보기
        // 사용방법 스스로 익혀보기
        ArrayList<Integer> numInt = new ArrayList<>();
        ArrayList<Double> numDouble = new ArrayList<>();
        ArrayList<Boolean> flag = new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();

        numInt.add(1);
        numInt.add(10);

        numDouble.add(3.3);
        numDouble.add(9.7);


        flag.add(true);
        flag.add(false);

        System.out.println(numInt.get(0));
        System.out.println(numInt.get(1));

        System.out.println(numDouble.get(0));
        numDouble.remove(3.3);
        System.out.println(numDouble.get(0));


        System.out.println(flag.get(0));
        System.out.println(flag.get(1));

        Book book = new Book();
        bookList.add(book);
        System.out.println(bookList.getFirst().title);


    } // end of main

    static class Book{
        String title="데미안";

        public void bookName() {
            System.out.println(this.title);
        }
    }
}
