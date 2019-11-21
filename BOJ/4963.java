import java.io.*;
import java.util.*;
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
    public static final int[] dy = {1, -1, 0, 0, -1, -1, 1, 1};
    public static void bfs(int[][] a, int[][] group, int x, int y, int cnt, int w, int h){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        group[x][y] = cnt;
        while(!q.isEmpty()){
            Pair p = q.remove();
            x = p.x;
            y = p.y;
            for(int k = 0; k < 8; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(0 <= nx && nx < w && 0 <= ny && ny < h){
                    if(a[nx][ny] == 1 && group[nx][ny] == 0) {
                        q.add(new Pair(nx, ny));
                        group[nx][ny] = cnt;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        while(true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if(w == 0 && h == 0)
                break;
            int[][] a = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int cnt = 0;
            int[][] group = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (a[i][j] == 1 && group[i][j] == 0) {
                        bfs(a, group, i, j, ++cnt, h, w);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
