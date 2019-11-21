import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] check;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(int x, int y, int height){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        check[x][y] = true;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int xx = p.x;
            int yy = p.y;
            for(int k = 0; k < 4; k++){
                int nx = xx + dx[k];
                int ny = yy + dy[k];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if(!check[nx][ny] && arr[nx][ny] > height){
                        q.add(new Pair(nx, ny));
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(line[j]);
        }
        int num = 0;
        int height = 0;
        int max = Integer.MIN_VALUE;
        while(height < 101) {
            num = 0;
            check = new boolean[n][n];
            for (int i = 0; i < n * n; i++) {
                int x = i / n;
                int y = i % n;
                if (arr[x][y] > height && !check[x][y]) {
                    bfs(x, y, height);
                    num++;
                }
            }
            height++;
            max = Math.max(num, max);
        }
        System.out.println(max);
    }
}
