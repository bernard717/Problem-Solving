import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        func(n, 1, 3);
        System.out.println(cnt);
        System.out.print(sb);
    }
    public static void func(int n, int a, int b){
        if(n == 1) {
            sb.append(a + " " + b + "\n");
            cnt++;
            return;
        }
        int c = 6 - a - b;
        func(n - 1, a, c);
        func(1, a, b);
        func(n - 1, c, b);
    }
}
