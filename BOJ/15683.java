import java.util.*;
import java.io.*;
public class Main {
    static int[][] a;
    static int min = Integer.MAX_VALUE;
    static int n, m;
    static boolean[][] check;
    public static void up(int x, int y){
        for(int i = x - 1; i >= 0; i--){
            if(a[i][y] != 6)
                check[i][y] = true;
            else
                break;
        }
    }
    public static void checkup(boolean[][] check, boolean[][] check2, int x, int y){
        for(int i = x - 1; i >= 0; i--)
            check[i][y] = check2[i][y];
    }
    public static void down(int x, int y){
        for(int i = x + 1; i < n; i++){
            if(a[i][y] != 6)
                check[i][y] = true;
            else
                break;
        }
    }
    public static void checkdown(boolean[][] check, boolean[][] check2, int x, int y){
        for(int i = x + 1; i < n; i++)
            check[i][y] = check2[i][y];
    }
    public static void left(int x, int y){
        for(int i = y - 1; i >= 0; i--){
            if(a[x][i] != 6)
                check[x][i] = true;
            else
                break;
        }
    }
    public static void checkleft(boolean[][] check, boolean[][] check2, int x, int y){
        for(int i = y - 1; i >= 0; i--)
            check[x][i] = check2[x][i];
    }
    public static void right(int x, int y){
        for(int i = y + 1; i < m; i++){
            if(a[x][i] != 6)
                check[x][i] = true;
            else
                break;
        }
    }
    public static void checkright(boolean[][] check, boolean[][] check2, int x, int y){
        for(int i = y + 1; i < m; i++)
            check[x][i] = check2[x][i];
    }
    public static void go(int z, boolean[][] check){
        if(z == n * m) {
            int left = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(!check[i][j] && a[i][j] == 0)
                        left++;
                }
            }
            min = Math.min(left, min);
            return;
        }
        boolean [][] check2 = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                check2[i][j] = check[i][j];
        }
        int x = z / m;
        int y = z % m;
        if(a[x][y] == 0 || a[x][y] == 6)
            go(z + 1, check);
        else if(a[x][y] == 1){
            up(x, y);
            go(z + 1, check);
            checkup(check, check2, x, y);
            down(x, y);
            go(z + 1, check);
            checkdown(check, check2, x, y);
            right(x, y);
            go(z + 1, check);
            checkright(check, check2, x, y);
            left(x, y);
            go(z + 1, check);
            checkleft(check, check2, x, y);
        }
        else if(a[x][y] == 2){
            up(x, y);
            down(x, y);
            go(z + 1, check);
            checkup(check, check2, x, y);
            checkdown(check, check2, x, y);
            right(x, y);
            left(x, y);
            go(z + 1, check);
            checkright(check, check2, x, y);
            checkleft(check, check2, x, y);
        }
        else if(a[x][y] == 3){
            up(x, y);
            left(x, y);
            go(z + 1, check);
            checkup(check, check2, x, y);
            checkleft(check, check2, x, y);
            up(x, y);
            right(x, y);
            go(z + 1, check);
            checkup(check, check2, x, y);
            checkright(check, check2, x, y);
            down(x, y);
            left(x, y);
            go(z + 1, check);
            checkdown(check, check2, x, y);
            checkleft(check, check2, x, y);
            down(x, y);
            right(x, y);
            go(z + 1, check);
            checkdown(check, check2, x, y);
            checkright(check, check2, x, y);
        }
        else if(a[x][y] == 4){
            up(x, y);
            left(x, y);
            right(x, y);
            go(z + 1, check);
            checkup(check, check2, x, y);
            checkleft(check, check2, x, y);
            checkright(check, check2, x, y);
            up(x, y);
            right(x, y);
            down(x, y);
            go(z + 1, check);
            checkup(check, check2, x, y);
            checkright(check, check2, x, y);
            checkdown(check, check2, x, y);
            down(x, y);
            left(x, y);
            right(x, y);
            go(z + 1, check);
            checkdown(check, check2, x, y);
            checkleft(check, check2, x, y);
            checkright(check, check2, x, y);
            down(x, y);
            up(x, y);
            left(x, y);
            go(z + 1, check);
            checkdown(check, check2, x, y);
            checkup(check, check2, x, y);
            checkleft(check, check2, x, y);
        }
        else if(a[x][y] == 5){
            down(x, y);
            up(x, y);
            left(x, y);
            right(x, y);
            go(z + 1, check);
            checkdown(check, check2, x, y);
            checkup(check, check2, x, y);
            checkleft(check, check2, x, y);
            checkright(check, check2, x, y);
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        a = new int[n][m];
        check = new boolean[n][m];
        int left = 0;
        for(int i = 0; i < n; i++){
            String[] line2 = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                int what = Integer.parseInt(line2[j]);
                if(what == 0)
                    left++;
                a[i][j] = what;
            }
        }
        go(0, check);
        System.out.println(min);
    }
}
