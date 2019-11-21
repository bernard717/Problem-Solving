import java.io.*;
import java.util.*;
public class Main{
    static boolean[][] a;
    static boolean[] check;
    static boolean[] check_dig1;
    static boolean[] check_dig2;
    static int n;
    public static boolean check(int row, int col){
        if(check[col])
            return false;
        if(check_dig1[row + col])
            return false;
        if(check_dig2[row - col + n])
            return false;
        return true;
    }
    public static int calc(int row){
        if(row == n)
            return 1;
        int cnt = 0;
        for(int col = 0; col < n; col++){
            if(check(row, col)) {
                a[row][col] = true;
                check[col] = true;
                check_dig1[row+col] = true;
                check_dig2[row - col + n] = true;
                cnt += calc(row + 1);
                a[row][col] = false;
                check[col] = false;
                check_dig1[row+col] = false;
                check_dig2[row - col + n] = false;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        a = new boolean[15][15];
        check = new boolean[15];
        check_dig1 = new boolean[30];
        check_dig2 = new boolean[30];
        System.out.println(calc(0));
    }
}
