import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] queue = new int[2000000];

        int front = 0;
        int back = -1;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < num; i++){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("push")){
                int pushed = Integer.parseInt(s[1]);
                queue[++back] = pushed;
            }
            else if(s[0].equals("pop")){
                if(back < front)
                    sb.append("-1\n");
                else
                    sb.append(queue[front++] + "\n");
            }
            else if(s[0].equals("front")){
                if(back < front)
                    sb.append("-1\n");
                else
                    sb.append(queue[front] + "\n");
            }
            else if(s[0].equals("back")){
                if(back < front)
                    sb.append("-1\n");
                else
                    sb.append(queue[back] + "\n");
            }
            else if(s[0].equals("size"))
                sb.append(back - front + 1 + "\n");
            else if(s[0].equals("empty")){
                if(back < front)
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }
        }
        System.out.print(sb.toString());
    }
}
