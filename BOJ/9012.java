import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        while(num-- > 0){
            String line = br.readLine();
            Stack<Character> st = new Stack<Character>();
            int cnt = 0;
            boolean VPS = true;
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) == '('){
                    cnt++;
                }
                else {
                    if (cnt < 1)
                        VPS = false;
                    else
                        cnt--;
                }
            }
            if(cnt != 0)
                VPS = false;
            if(VPS)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
