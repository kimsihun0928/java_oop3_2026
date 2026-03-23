package collection.ex;

import java.util.Scanner;

// 메인에서 실행해보기
public class MemberMain {

    static final int MEMBER_REGISTER = 1;
    static final int MEMBER_SEARCH = 2;
    static final int MEMBER_REVISE = 3;
    static final int MEMBER_DELETE = 4;
    static final int MEMBER_LIST = 5;
    static int count = 1;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Member[] members = new Member[100];


        // 기능:
        //  1. 회원 가입   (Create)
        //  2. 회원 조회   (Read)
        //  3. 회원 수정   (Update)
        //  4. 회원 삭제   (Delete)
        //  5. 전체 목록   (Read All)


        System.out.println("=== 기능 ===");
        System.out.println("1. 회원 가입");
        System.out.println("2. 회원 조회");
        System.out.println("3. 회원 수정");
        System.out.println("4. 회원 삭제");
        System.out.println("5. 전체 목록");

        int choice = sc.nextInt();

        if (choice == MEMBER_REGISTER) {
            sc.nextLine();
            System.out.print("이름 : ");
            String name = sc.nextLine();
            System.out.print("이메일 : ");
            String email = sc.nextLine();
            for (int i = 0; i < members.length; i++) {
                if (members[i].getEmail().equals(email) == true) {
                    System.out.println("[오류] 이메일 중복입니다.");
                    return;
                }
            }
            System.out.print("나이 : ");
            int age = sc.nextInt();
            int id = count++;
            for (int i = 0; i < members.length; i++) {
                if (members[i] == null) {
                    members[i].setName(name);
                    members[i].setEmail(email);
                    members[i].setAge(age);
                    members[i].setId(id);
                    System.out.println("[완료] 회원가입 " + name + " (ID: " + id + ")");
                    break;
                }
            }

//        } else if (choice == 2) {
//            read();
//        } else if (choice == 3) {
//            update();
//        } else if (choice == 4) {
//            delete;
//        } else if (choice == 5) {
//            readAll();
//        } else {
            System.out.println("올바른 숫자를 입력해주세요");
        }

    }



}
