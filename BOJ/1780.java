import java.io.*;
import java.util.*;

public class Main{
    public static boolean same(int[][] a, int x, int y, int n){
        int what = a[x][y];
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                if(a[i][j] != what)
                    return false;
            }
        }
        return true;
    }
    public static void solve(int[][] a, int[] b, int x, int y, int n){
        if(same(a, x, y, n)){
            b[a[x][y] + 1] += 1;
            return;
        }
        int m = n / 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                solve(a, b,x + m*i, y + m*j, m);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(line[j]);
        }
        int[] b = new int[3];
        solve(a, b, 0, 0, n);
        for(int i = 0; i < 3; i++){
            System.out.println(b[i]);
        }
    }
}
