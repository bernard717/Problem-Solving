import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        int[] array = new int[n+1];
        for(int i = 1; i <= n; i++)
            array[i] = Integer.parseInt(br.readLine());
        int k = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            stack.push(i);
            sb.append("+"+ "\n");
            while(k <= n && !stack.empty() && array[k] == stack.peek()){
                stack.pop();
                sb.append("-"+"\n");
                k++;
            }
        }
        if(!stack.empty())
            System.out.println("NO");
        else
            System.out.print(sb);
    }
}
