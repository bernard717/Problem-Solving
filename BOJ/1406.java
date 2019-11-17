import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int num = Integer.parseInt(br.readLine());
        Stack<Character> stLeft = new Stack<Character>();
        Stack<Character> stRight = new Stack<Character>();
        for(int i = 0; i < line.length(); i++)
            stLeft.push(line.charAt(i));

        while(num-- > 0) {
            String order = br.readLine();
            if (order.charAt(0) == 'L') {
                if (!stLeft.empty())
                    stRight.push(stLeft.pop());
            } else if (order.charAt(0) == 'D') {
                if (!stRight.empty())
                    stLeft.push(stRight.pop());
            } else if (order.charAt(0) == 'B') {
                if (!stLeft.empty()) {
                    stLeft.pop();
                }
            } else
                stLeft.push(order.charAt(2));
        }
        StringBuilder sb = new StringBuilder();
        while(!stLeft.empty())
            sb.append(stLeft.pop());
        sb.reverse();
        while(!stRight.empty())
            sb.append(stRight.pop());

        System.out.println(sb);
    }
}
