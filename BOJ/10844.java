import java.io.*;
import java.util.*;

public class Main {
    public static long mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        long [][] d = new long[cnt + 1][10];
        for(int i = 1; i < 10; i++)
            d[1][i] = 1;

        for(int i = 2; i <= cnt; i++){
            for(int j = 0; j < 10; j++){
                if(j-1 >= 0)
                    d[i][j] += d[i-1][j-1];
                if(j+1 <= 9)
                    d[i][j] += d[i-1][j+1];
                d[i][j] %= mod;
            }
        }
        long ans = 0;
        for(int i = 0; i < 10; i++)
            ans += d[cnt][i];
        ans %= mod;
        System.out.println(ans);

    }
}
