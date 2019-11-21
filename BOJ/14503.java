import java.util.*;
import java.io.*;
public class Main {
    static int[][] a;
    static int n, m;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int ans = 0;
    public static void go(int x, int y, int dir, int what){
        int k;
        if(a[x][y] != 7) {
            ans++;
            a[x][y] = 7;
        }
        boolean judge = false;
        for(k = 0; k < 4; k++){
            dir = (dir + 3) % 4;
            if(checkFront(x, y, dir)){
                judge = true;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                go(nx, ny, dir, 0);
                break;
            }
        }
        if(!judge) {
            dir = (dir + 2) % 4;
            if (checkFront2(x, y, dir)) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                dir = (dir + 2) % 4;
                go(nx, ny, dir, 1);
            }
        }
    }
    public static boolean checkFront(int x, int y, int dir){
        if(dir == 0)
            return x >= 1 && a[x - 1][y] == 0;
        else if(dir == 1)
            return y + 1 < m && a[x][y + 1] == 0;
        else if(dir == 2)
            return x + 1 < n && a[x + 1][y] == 0;
        else
            return y >= 1 && a[x][y - 1] == 0;
    }
    public static boolean checkFront2(int x, int y, int dir){
        if(dir == 0)
            return x >= 1 && a[x - 1][y] == 7;
        else if(dir == 1)
            return y + 1 < m && a[x][y + 1] == 7;
        else if(dir == 2)
            return x + 1 < n && a[x + 1][y] == 7;
        else
            return y >= 1 && a[x][y - 1] == 7;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        a = new int[n][m];
        String[] line1 = br.readLine().split(" ");
        int robotX = Integer.parseInt(line1[0]);
        int robotY = Integer.parseInt(line1[1]);
        int robotDir = Integer.parseInt(line1[2]);
        for(int i = 0; i < n; i++){
            String[] line2 = br.readLine().split(" ");
            for(int j = 0; j < m; j++)
                a[i][j] = Integer.parseInt(line2[j]);
        }
        go(robotX, robotY, robotDir, 0);
        System.out.println(ans);
    }
}
