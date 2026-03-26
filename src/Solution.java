public class Solution {

    boolean solution(String s) {

        char[] ch = s.toCharArray();
        boolean answer = false;
        int count = 0;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                count++;
            } else if (ch[i] == ')') {
                count--;
            }
            if (count < 0) {
                answer = false;
                break;
            }
        }
        if (count == 0) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}
