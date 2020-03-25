import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<String> stack = new Stack<>();
        boolean wrong = false;

        for(int i = 0; i < s.length(); i++){
            String c = s.substring(i, i + 1);

            if(c.equals("(") || c.equals("["))
                stack.push(c);
            else if(c.equals(")")) {
                if(stack.isEmpty() || !stack.peek().equals("(")){
                    wrong = true;
                    break;
                }
                else
                    stack.pop();
            }
            else {
                if(stack.isEmpty() || !stack.peek().equals("[")){
                    wrong = true;
                    break;
                }
                else
                    stack.pop();
            }
        }
        if(!stack.isEmpty() || wrong){
            System.out.print(0);
            return;
        }
        stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            String c = s.substring(i, i + 1);
            if(c.equals("(") || c.equals("["))
                stack.push(c);
            else{
                if(c.equals(")")){
                    if(stack.peek().equals("(")){
                        stack.pop();
                        stack.push(Integer.toString(2));
                    }
                    else{
                        int num = 0;
                        while(!stack.peek().equals("(")) {
                            num += Integer.parseInt(stack.pop());
                        }
                        stack.pop();
                        stack.push(Integer.toString(num * 2));
                    }
                }
                else if(c.equals("]")){
                    if(stack.peek().equals("[")){
                        stack.pop();
                        stack.push(Integer.toString(3));
                    }
                    else{
                        int num = 0;
                        while(!stack.peek().equals("[")) {
                            num += Integer.parseInt(stack.pop());
                        }
                        stack.pop();
                        stack.push(Integer.toString(num * 3));
                    }
                }
            }
        }
        int answer = 0;
        while(!stack.isEmpty())
            answer += Integer.parseInt(stack.pop());
        System.out.print(answer);
    }
}
