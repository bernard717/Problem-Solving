import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main {
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] a;
    static boolean[][] d;
    static int[][] union;
    static ArrayList<Integer>[] open;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int n;
    static ArrayList<Pair>[] same;
    static Pair[] pairs;
    public static void bfs(int x, int y, int cnt){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        union[x][y] = cnt;
        int sum = 0;
        int num = 0;
        sum += a[x][y];
        num++;
        same[cnt].add(new Pair(x, y));
        while(!q.isEmpty()){
            Pair p = q.remove();
            int nx = p.x;
            int ny = p.y;
            for(int k = 0; k < 4; k++){
                int kx = nx + dx[k];
                int ky = ny + dy[k];
                if(kx >= 0 && kx < n && ky >= 0 && ky < n){
                    if(open[nx * n + ny].contains(kx * n + ky) && union[kx][ky] == 0){
                        q.add(new Pair(kx, ky));
                        union[kx][ky] = cnt;
                        sum += a[kx][ky];
                        num++;
                        same[cnt].add(new Pair(kx, ky));
                    }
                }
            }
        }
        pairs[cnt] = new Pair(sum, num);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        int l = Integer.parseInt(line[1]);
        int r = Integer.parseInt(line[2]);
        a = new int[n][n];
        open = new ArrayList[n * n];
        union = new int[n][n];
        same = new ArrayList[n * n + 1];
        pairs = new Pair[n * n];
        for(int i = 0; i < n * n; i++)
            open[i] = new ArrayList<Integer>();
        for(int i = 0; i < n * n; i++)
            same[i] = new ArrayList<Pair>();
        for(int i = 0; i < n; i++){
            String[] line2 = br.readLine().split(" ");
            for(int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(line2[j]);
        }
        int ans = 0;
        int temp = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                        int diff = Math.abs(a[i][j] - a[nx][ny]);
                        if(diff >= l && diff <= r)
                            open[i * n + j].add(nx * n + ny);
                    }
                }
            }
        }
        for(int i = 0; i < n * n; i++)
            temp += open[i].size();
        while(temp != 0){
            int cnt = 0;
            union = new int[n][n];
            same = new ArrayList[n * n + 1];
            for(int i = 0; i < n * n; i++)
                same[i] = new ArrayList<Pair>();
            pairs = new Pair[n * n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(union[i][j] == 0)
                        bfs(i, j, ++cnt);
                }
            }
            for(int i = 1; i <= cnt; i++){
                for(Pair p: same[i]){
                    a[p.x][p.y] = pairs[i].x / pairs[i].y;
                }
            }
            open = new ArrayList[n * n];
            for(int i = 0; i < n * n; i++)
                open[i] = new ArrayList<Integer>();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                            int diff = Math.abs(a[i][j] - a[nx][ny]);
                            if(diff >= l && diff <= r)
                                open[i * n + j].add(nx * n + ny);
                        }
                    }
                }
            }
            temp = 0;
            for(int i = 0; i < n * n; i++)
                temp += open[i].size();
            ans++;
        }
        System.out.println(ans);
    }
}
