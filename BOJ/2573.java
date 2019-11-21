import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] a, d, check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    public static void bfs(int e, int f, int cnt){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(e, f));
        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(a[nx][ny] != 0 && d[nx][ny] == 0){
                    q.add(new Pair(nx, ny));
                    d[nx][ny] = cnt;
                }
            }
        }
    }
    public static void check(int x, int y){
        int count = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(a[nx][ny] == 0) count++;
        }
        check[x][y] = count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        Queue<Pair> q = new LinkedList<Pair>();
        a = new int[n][m];

        for(int i = 0; i < n; i++){
            String[] line2 = br.readLine().split(" ");
            for(int j = 0; j < m; j++)
                a[i][j] = Integer.parseInt(line2[j]);
        }
        int num = 0;
        while(num < 301 && num++ < 301){
            check = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++)
                    check(i, j);
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(a[i][j] != 0)
                        a[i][j] = Math.max(0, a[i][j] - check[i][j]);
                }
            }
            int cnt = 0;
            d = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(a[i][j] != 0 && d[i][j] == 0)
                        bfs(i, j, ++cnt);
                }
            }
            if(cnt > 1){
                System.out.println(num);
                return;
            }
        }
        System.out.println(0);
    }
}
