import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] d = new long[n + 1][3];
        d[1][0] = 1;
        d[1][1] = 1;
        d[1][2] = 1;
        for(int i = 2; i <= n; i++){
            d[i][0] = (d[i-1][0] + d[i-1][1] + d[i-1][2]) % 9901;
            d[i][1] = (d[i-1][0] + d[i-1][2]) % 9901;
            d[i][2] = (d[i-1][0] + d[i-1][1]) % 9901;
        }
        System.out.println((d[n][0] + d[n][1] + d[n][2]) % 9901);
    }
}
