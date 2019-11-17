import java.util.*;
import java.io.*;
public class Main {
    static int testnum;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][3];
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < 3; j++)
                a[i][j] = Integer.parseInt(line[j]);
        }
        int[][] d = new int[n][3];
        d[0][0] = a[0][0];
        d[0][1] = a[0][1];
        d[0][2] = a[0][2];
        for(int i = 1; i < n; i++){
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + a[i][0];
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + a[i][1];
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + a[i][2];
        }
        System.out.println(Math.min(Math.min(d[n - 1][0], d[n - 1][1]), d[n - 1][2])); 
    }
}
