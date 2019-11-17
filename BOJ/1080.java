import java.io.*;
import java.util.*;
public class Main{
    public static void change(int k, int l, int a[][]){
        for(int i = k; i < k + 3; i++){
            for(int j = l; j < l + 3; j++)
                a[i][j] = a[i][j] == 1 ? 0 : 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for(int j = 0; j < m; j++)
                a[i][j] = temp.charAt(j) - '0';
        }
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for(int j = 0; j < m; j++)
                b[i][j] = temp.charAt(j) - '0';
        }
        int ans = 0;
        for(int i = 0 ; i < n - 2; i++){
            for(int j = 0; j < m - 2; j++){
                if(a[i][j] != b[i][j]){
                    change(i, j, a);
                    ans++;
                }
            }
        }
        boolean judge = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != b[i][j]){
                    judge = false;
                    break;
                }
            }
            if(!judge)
                break;
        }
        if(!judge)
            System.out.println(-1);
        else
            System.out.println(ans); 

    }
}
