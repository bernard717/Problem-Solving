import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = 1;

        while(true) {
            String s = br.readLine();
            if(s.startsWith("-"))
                break;

            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);

                if(c == '{')
                    stack.push(c);
                else{
                    if(!stack.isEmpty() && stack.peek() == '{')
                        stack.pop();
                    else
                        stack.push('}');
                }
            }
            int answer = 0;
            int idx = 0;
            while(!stack.isEmpty()){
                if(idx % 2 == 0 && stack.peek() == '{') {
                    answer++;
                }
                else if(idx % 2 == 1 && stack.peek() == '}'){
                    answer++;
                }
                stack.pop();
                idx++;
            }
            System.out.println(test++ + ". " + answer);
        }
    }
}
