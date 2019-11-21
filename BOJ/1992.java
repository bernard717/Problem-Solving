import java.io.*;
import java.util.*;
public class Main{
    public static StringBuilder sb = new StringBuilder();
    public static boolean same(int[][] a, int x, int y, int n){
        int judge = a[x][y];
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                if(judge != a[i][j])
                    return false;
            }
        }
        return true;
    }
    public static void solve(int[][] a, int x, int y, int n){
        if(n == 0)
            return;
        if(same(a, x, y, n)){
            sb.append(a[x][y]);
            return;
        }
        sb.append("(");
        int m = n / 2;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                solve(a, x + i * m, y + j * m, m);
            }
        }
        sb.append(")");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++)
                a[i][j] = line.charAt(j) - '0';
        }

        solve(a, 0, 0, n);
        
        System.out.print(sb);
    }
}
