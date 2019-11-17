import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();

        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i = 1; i <= N; i++)
            queue.offer(i);
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(N-- > 1){
            for(int i = 0; i < M - 1; i++){
                queue.offer(queue.poll());
            }
            sb.append(queue.poll());
            sb.append(", ");
        }
        sb.append(queue.poll());
        sb.append(">");

        System.out.println(sb);
    } 
}
