import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] towers = new int[num];
        for(int i = 0; i < num; i++)
            towers[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        long answer = 0;

        for(int i = 0; i < num; i++){
            while(!stack.isEmpty() && stack.peek() <= towers[i])
                stack.pop();
            answer += stack.size();
            stack.push(towers[i]);
        }
        System.out.println(answer);
    }
}
