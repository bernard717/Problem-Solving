import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int[] t, p;
    static int max = Integer.MIN_VALUE;
    static int sum;
    public static void go(int x, int sum){
        if(x > n){
            if(sum > max)
                max = sum;
            return;
        }
        if(x + t[x] <= n + 1)
            go(x + t[x], sum + p[x]);
        go(x + 1, sum);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = new int[n + 1];
        p = new int[n + 1];
        for(int i = 1; i <= n; i++){
            String[] line = br.readLine().split(" ");
            t[i] = Integer.parseInt(line[0]);
            p[i] = Integer.parseInt(line[1]);
        }
        go(1, 0);
        System.out.println(max);
    }
}
