import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    static int[][] a;
    static int max = Integer.MIN_VALUE;
    public static int first1(int x, int y){
        int ans = 0;
        for(int i = 0; i < 4; i++)
            ans += a[x][y + i];
        return ans;
    }
    public static int first2(int x, int y){
        int ans = 0;
        for(int i = 0; i < 4; i++)
            ans += a[x + i][y];
        return ans;
    }
    public static int second(int x, int y){
        return a[x][y] + a[x + 1][y] + a[x][y + 1] + a[x + 1][y + 1];
    }
    public static int third1(int x, int y){
        return a[x][y] + a[x + 1][y] + a[x + 2][y] + a[x + 2][y + 1];
    }
    public static int third2(int x, int y){
        return a[x][y + 1] + a[x + 1][y + 1] + a[x + 2][y + 1] + a[x + 2][y];
    }
    public static int third3(int x, int y){
        return a[x][y] + a[x][y + 1] + a[x + 1][y + 1] + a[x + 2][y + 1];
    }
    public static int third4(int x, int y){
        return a[x][y] + a[x][y + 1] + a[x + 1][y] + a[x + 2][y];
    }
    public static int third5(int x, int y){
        return a[x][y] + a[x][y + 1] + a[x][y + 2] + a[x + 1][y];
    }
    public static int third6(int x, int y){
        return a[x][y] + a[x][y + 1] + a[x][y + 2] + a[x + 1][y + 2];
    }
    public static int third7(int x, int y){
        return a[x + 1][y] + a[x + 1][y + 1] + a[x + 1][y + 2] + a[x][y + 2];
    }
    public static int third8(int x, int y){
        return a[x][y] + a[x + 1][y] + a[x + 1][y + 1] + a[x + 1][y + 2];
    }
    public static int fourth1(int x, int y){
        return a[x][y] + a[x + 1][y] + a[x + 1][y + 1] + a[x + 2][y + 1];
    }
    public static int fourth2(int x, int y){
        return a[x + 1][y] + a[x + 2][y] + a[x + 1][y + 1] + a[x][y + 1];
    }
    public static int fourth3(int x, int y){
        return a[x][y + 1] + a[x][y + 2] + a[x + 1][y] + a[x + 1][y + 1];
    }
    public static int fourth4(int x, int y){
        return a[x][y] + a[x][y + 1] + a[x + 1][y + 1] + a[x + 1][y + 2];
    }
    public static int fifth1(int x, int y){
        return a[x][y] + a[x + 1][y] + a[x + 1][y + 1] + a[x + 2][y];
    }
    public static int fifth2(int x, int y){
        return a[x][y + 1] + a[x + 1][y + 1] + a[x + 2][y + 1] + a[x + 1][y];
    }
    public static int fifth3(int x, int y){
        return a[x][y + 1] + a[x + 1][y] + a[x + 1][y + 1] + a[x + 1][y + 2];
    }
    public static int fifth4(int x, int y){
        return a[x][y] + a[x][y + 1] + a[x][y + 2] + a[x + 1][y + 1];
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        a = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] line2 = br.readLine().split(" ");
            for(int j = 0; j < m; j++)
                a[i][j] = Integer.parseInt(line2[j]);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j + 3 < m; j++)
                max = Math.max(first1(i, j), max);
        }
        for(int i = 0; i + 3 < n; i++){
            for(int j = 0; j < m; j++)
                max = Math.max(first2(i, j), max);
        }

        for(int i = 0; i + 1 < n; i++){
            for(int j = 0; j + 1 < m; j++)
                max = Math.max(second(i, j), max);
        }

        for(int i = 0; i + 2 < n; i++){
            for(int j = 0; j + 1 < m; j++)
                max = Math.max(third1(i, j), max);
        }

        for(int i = 0; i + 2 < n; i++){
            for(int j = 0; j + 1 < m; j++)
                max = Math.max(third2(i, j), max);
        }
        for(int i = 0; i + 2 < n; i++){
            for(int j = 0; j + 1 < m; j++)
                max = Math.max(third3(i, j), max);
        }
        for(int i = 0; i + 2 < n; i++){
            for(int j = 0; j + 1 < m; j++)
                max = Math.max(third4(i, j), max);
        }
        for(int i = 0; i + 1 < n; i++){
            for(int j = 0; j + 2 < m; j++)
                max = Math.max(third5(i, j), max);
        }
        for(int i = 0; i + 1 < n; i++){
            for(int j = 0; j + 2 < m; j++)
                max = Math.max(third6(i, j), max);
        }
        for(int i = 0; i + 1 < n; i++){
            for(int j = 0; j + 2 < m; j++)
                max = Math.max(third7(i, j), max);
        }
        for(int i = 0; i + 1 < n; i++){
            for(int j = 0; j + 2 < m; j++)
                max = Math.max(third8(i, j), max);
        }
        for(int i = 0; i + 2 < n; i++){
            for(int j = 0; j + 1 < m; j++)
                max = Math.max(fourth1(i, j), max);
        }
        for(int i = 0; i + 2 < n; i++){
            for(int j = 0; j + 1 < m; j++)
                max = Math.max(fourth2(i, j), max);
        }
        for(int i = 0; i + 1 < n; i++){
            for(int j = 0; j + 2 < m; j++)
                max = Math.max(fourth3(i, j), max);
        }
        for(int i = 0; i + 1 < n; i++){
            for(int j = 0; j + 2 < m; j++)
                max = Math.max(fourth4(i, j), max);
        }
        for(int i = 0; i + 2 < n; i++){
            for(int j = 0; j + 1 < m; j++)
                max = Math.max(fifth1(i, j), max);
        }
        for(int i = 0; i + 2 < n; i++){
            for(int j = 0; j + 1 < m; j++)
                max = Math.max(fifth2(i, j), max);
        }
        for(int i = 0; i + 1 < n; i++){
            for(int j = 0; j + 2 < m; j++)
                max = Math.max(fifth3(i, j), max);
        }
        for(int i = 0; i + 1 < n; i++){
            for(int j = 0; j + 2 < m; j++)
                max = Math.max(fifth4(i, j), max);
        }
        System.out.println(max);
    }
}
