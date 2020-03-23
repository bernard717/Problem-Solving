import java.util.*;

class Solution {
    public int solution(String arrangement) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        boolean flag = false;

        for(int i = 0; i < arrangement.length(); i++){
            char c = arrangement.charAt(i);

            if(c == '(') {
                stack.push(c);
                flag = false;
            }

            else{
                if(!flag){
                    stack.pop();
                    flag = true;
                    answer += stack.size();
                }
                else{
                    stack.pop();
                    flag = false;
                    answer += 1;
                }
            }
        }

        return answer + 1;
    }
}
