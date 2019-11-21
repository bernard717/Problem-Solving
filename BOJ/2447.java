import java.io.*;
import java.util.*;
public class Main{
    public static StringBuilder sb = new StringBuilder();
    public static void solve(char[][] a, int x, int y, int n){
        if(n == 0)
            return;
        for(int i = 0; i < n / 3; i++){
            for(int j = 0; j < n / 3; j++){
                a[x+n/3+i][y+n/3+j] = ' ';
            }
        }
        n /= 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                solve(a,x + i * n, y + j * n, n);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] a = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                a[i][j] = '*';
        }
        solve(a, 0, 0,  n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(a[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
