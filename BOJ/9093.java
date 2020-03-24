import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++) {
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(c == ' '){
                    while(!stack.isEmpty())
                        sb.append(stack.pop());
                    sb.append(" ");
                }
                else
                    stack.push(c);
            }
            while(!stack.isEmpty())
                sb.append(stack.pop());
            System.out.println(sb.toString());
        }
    }
}
