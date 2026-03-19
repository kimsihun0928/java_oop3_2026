package test;

public class Test {

    private static final String KEY = "DLG3TL5ST24KDY";

    public static void main(String[] args) {

        // 1. 상수 활용: 인증키 값은 보안상 프로그램 실행 중 변경되어서는 안 됩니다. final 예약어를 사용하여 문자열 상수를 선언하고 임의의 키 값을 할당하십시오.
        // 2. 유효성 검사: if-else 문을 사용하여, 상수에 저장된 키 값이 비어 있지 않으면 "인증 성공"을, 비어 있으면(예: "") "키를 등록하세요"를 출력하도록 구현하십시오.

        if (KEY.length() > 0) {
            System.out.println("인증 성공");
        } else {
            System.out.println("키를 등록하세요");
        }

    }
}
