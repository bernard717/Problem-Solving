import java.util.*;
import java.io.*;

public class Main {
    static int[][] a, d;
    static int n;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
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
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        d = new int[n][n];
        Pair[] height = new Pair[n * n];
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(line[j]);
                height[i * n + j] = new Pair(i, j, a[i][j]);
            }
        }
        Arrays.sort(height);
        int max = 0;
        for(int z = n * n - 1; z >= 0; z--) {
            int i = height[z].x;
            int j = height[z].y;
            for (int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (a[i][j] < a[nx][ny])
                        d[i][j] = Math.max(d[nx][ny] + 1, d[i][j]);
                    max = Math.max(max, d[i][j]);
                }
            }
        }
        System.out.println(max + 1);
    }
}
