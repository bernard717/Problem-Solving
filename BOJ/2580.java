import java.io.*;
import java.util.*;
public class Main{
    static int[][] a;
    static boolean[][] row_check;
    static boolean[][] col_check;
    static boolean[][] small_check;
    static int n, zero;
    public static boolean go(int z){
        if (z == 81) {
            for (int i=0; i < n; i++) {
                for (int j=0; j < n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        int row = z / n;
        int col = z % n;
        if(a[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (!row_check[row][i] && !col_check[col][i] && !small_check[(row / 3) * 3 + (col / 3)][i]) {
                    a[row][col] = i;
                    row_check[row][i] = true;
                    col_check[col][i] = true;
                    small_check[(row / 3) * 3 + (col / 3)][i] = true;
                    if (go(z + 1))
                        return true;
                    a[row][col] = 0;
                    row_check[row][i] = false;
                    col_check[col][i] = false;
                    small_check[(row / 3) * 3 + (col / 3)][i] = false;
                }
            }
        }
        else
            return go(z + 1);
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = 9;
        row_check = new boolean[n][n + 1];
        col_check = new boolean[n][n + 1];
        small_check = new boolean[n][n + 1];
        zero = 0;
        a = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                int temp = Integer.parseInt(line[j]);
                a[i][j] = temp;
                if(temp != 0){
                    row_check[i][temp] = true;
                    col_check[j][temp] = true;
                    small_check[(i/3) * 3 + (j/3)][temp] = true;
                }
                else
                    zero++;
            }
        }
        go(0);
    }
}
