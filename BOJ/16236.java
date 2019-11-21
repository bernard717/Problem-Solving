import java.util.*;
import java.io.*;
public class Main {
    static int[][] a;
    static boolean[][] route;
    static boolean[][] fish;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static boolean[][] check;
    static int[][] dist;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Pair2{
        int x, y, z;
        Pair2(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static Pair2 bfs(int startX, int startY){
        check = new boolean[n][n];
        dist = new int[n][n];
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(startX, startY));
        check[startX][startY] = true;
        dist[startX][startY] = 0;
        while(!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!check[nx][ny] && route[nx][ny]) {
                        q.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                        check[nx][ny] = true;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int eatX = 0, eatY = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(fish[i][j]){
                    if(min > dist[i][j] && dist[i][j] != 0) {
                        min = dist[i][j];
                        eatX = i;
                        eatY = j;
                    }
                }
            }
        }
        if(min == Integer.MAX_VALUE)
            return new Pair2(-1, -1, min);
        fish[eatX][eatY] = false;
        route[startX][startY] = true;
        a[startX][startY] = 0;
        return new Pair2(eatX, eatY, min);
    }
    public static int go(int startX, int startY, int eat, int sharkSize, int current, int dist){
        if(eat == 0)
            return dist;
        Pair2 p = bfs(startX, startY);
        if(p.x == -1)
            return dist;
        current++;
        eat--;
        dist += p.z;
        if(sharkSize == current) {
            sharkSize++;
            current = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(a[i][j] == sharkSize)
                        route[i][j] = true;
                    if(a[i][j] == sharkSize - 1){
                        fish[i][j] = true;
                        eat++;
                    }
                }
            }
        }
        return go(p.x, p.y, eat, sharkSize, current, dist);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        route = new boolean[n][n];
        fish = new boolean[n][n];
        int eat = 0;
        int startX = 0, startY = 0;
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                int what = Integer.parseInt(line[j]);
                a[i][j] = what;
                if(what == 9){
                    startX = i;
                    startY = j;
                }
                if(what <= 2)
                    route[i][j] = true;
                if(what < 2 && what > 0){
                    fish[i][j] = true;
                    eat++;
                }
            }
        }
        System.out.println(go(startX, startY, eat, 2, 0, 0));
    }
}
