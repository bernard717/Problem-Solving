import java.util.Stack;

class Solution {
    public String solution(String p) {
        if(p.length() == 0)
            return p;

        String u = "", v = "";

        for(int i = 2; i <= p.length(); i++){
            u = p.substring(0, i);
            v = p.substring(i, p.length());
            if(isBalanced(u) && isBalanced(v))
                break;
        }
        if(isRight(u))
            return u + solution(v);
        else{
            StringBuilder temp = new StringBuilder();
            temp.append("(").append(solution(v)).append(")");
            u = u.substring(1, u.length() - 1);
            for(int i = 0; i < u.length(); i++){
                if(u.charAt(i) == '(')
                    temp.append(")");
                else
                    temp.append("(");
            }
            return temp.toString();
        }
    }
    public boolean isBalanced(String p){
        int num1 = 0, num2 = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(')
                num1++;
            else
                num2++;
        }
        return num1 == num2;
    }
    public boolean isRight(String p){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(')
                stack.push('(');
            else {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
