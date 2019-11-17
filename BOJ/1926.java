import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    static int[][] a;
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
    static int go(int x, int y){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        check[x][y] = true;
        int num = 1;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int xx = p.x;
            int yy = p.y;
            for(int k = 0; k < 4; k++){
                int nx = xx + dx[k];
                int ny = yy + dy[k];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(!check[nx][ny] && a[nx][ny] == 1){
                        q.add(new Pair(nx, ny));
                        num++;
                        check[nx][ny] = true;
                    }
                }
            }
        }
        return num;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        a = new int[n][m];
        check = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String[] line1 = br.readLine().split(" ");
            for(int j = 0; j < m; j++)
                a[i][j] = Integer.parseInt(line1[j]);
        }
        int max = Integer.MIN_VALUE;
        int num = 0;
        for(int i = 0; i < n * m; i++){
            int x = i / m;
            int y = i % m;
            if(a[x][y] == 1 && !check[x][y]){
                max = Math.max(max, go(x, y));
                num++;
            }
        }
        System.out.println(num);
        if(num == 0)
            System.out.println(0);
        else
            System.out.println(max);
    } 
}
