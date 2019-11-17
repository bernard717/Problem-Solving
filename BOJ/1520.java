import java.util.*;
import java.io.*;
public class Main {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static class Pair implements Comparable<Pair>{
        int x, y, height;
        Pair(int x, int y, int height){
            this.x = x;
            this.y = y;
            this.height = height;
        }
        public int compareTo(Pair that){
            if(this.height < that.height)
                return -1;
            else if(this.height == that.height)
                return 0;
            else
                return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[][] a = new int[n][m];
        Pair[] p = new Pair[n * m];
        for(int i = 0; i < n; i++){
            String[] line1 = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(line1[j]);
                p[i * m + j] = new Pair(i, j, a[i][j]);
            }
        }
        Arrays.sort(p);
        int[][] d = new int[n][m];
        d[0][0] = 1;
        for(int i = n * m - 1; i >= 0; i--){
            int x = p[i].x;
            int y = p[i].y;
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(a[nx][ny] < a[x][y])
                        d[nx][ny] += d[x][y];
                }
            }
        }
        System.out.println(d[n-1][m-1]);
    }
}
