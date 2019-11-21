import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] a = new ArrayList[n];
        for(int i = 0; i < n; i++)
            a[i] = new ArrayList<Integer>();
        ArrayList<Integer>[] dp = new ArrayList[n];
        for(int i = 0; i < n; i++)
            dp[i] = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j <= i; j++)
                a[i].add(Integer.parseInt(line[j]));
        }
        dp[0].add(a[0].get(0));
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                int max;
                if(j == 0)
                    max = dp[i - 1].get(j);
                else if(j == i)
                    max = dp[i - 1].get(j - 1);
                else
                    max = Math.max(dp[i - 1].get(j - 1), dp[i - 1].get(j));
                dp[i].add(max + a[i].get(j));
            }
        }
        Collections.sort(dp[n - 1]);
        System.out.println(dp[n - 1].get(n - 1));
    }
}
