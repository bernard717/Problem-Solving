import java.util.*;
import java.io.*;

public class Main {
    static int[][] a;
    static long[][] d;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        d = new long[n][n];
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(line[j]);
        }
        d[0][0] = 1;
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                for(int i = 0; i < x; i++){
                    if(i + a[i][y] == x)
                        d[x][y] += d[i][y];
                }
                for(int i = 0; i < y; i++){
                    if(i + a[x][i] == y)
                        d[x][y] += d[x][i];
                }
            }
        }
        System.out.println(d[n - 1][n - 1]);
    }
}
