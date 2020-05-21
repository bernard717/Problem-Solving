import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static boolean isOpening(char c){
        return c == '(' || c == '{' || c == '[';
    }
    public static boolean matches(char a, char b){
        if(a == '(' && b == ')')
            return true;
        if(a == '{' && b == '}')
            return true;
        if(a == '[' && b == ']')
            return true;
        return false;
    }

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            // 괄호 여는 부분일 경우
            if(isOpening(c)){
                st.push(c);
            }
            // 괄호 닫는 부분일 경우
            else{
                if(st.isEmpty())
                    return "NO";
                if(!matches(st.pop(), c))
                    return "NO";
            }
        }
        if(st.isEmpty())
            return "YES";
        else
            return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
