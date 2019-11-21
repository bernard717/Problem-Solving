import java.io.*;
import java.util.*;
public class Main{
    public static char[][] a;
    public static StringBuilder sb = new StringBuilder();
    public static void solve(int x, int y, int n){
        if(n == 3){
            a[x][y] = '*';
            a[x+1][y-1] = a[x+1][y+1] = '*';
            a[x+2][y-2] = a[x+2][y-1] = a[x+2][y] = a[x+2][y+1] = a[x+2][y+2] = '*';
            return;
        }
        solve(x, y, n/2);
        solve(x+n/2, y-n/2, n/2);
        solve(x+n/2, y+n/2, n/2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        a = new char[n][2*n-1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2*n-1; j++)
                a[i][j] = ' ';
        }
        solve(0, n-1, n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2*n-1; j++){
                sb.append(a[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
