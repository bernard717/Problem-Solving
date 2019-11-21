import java.util.*;
import java.io.*;
public class Main {
    static final int[] dx = {0, -1, -1};
    static final int[] dy = {-1, 0, -1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] line1 = br.readLine().split(" ");
            for(int j = 0; j < m; j++)
                a[i][j] = Integer.parseInt(line1[j]);
        }
        int[][] d = new int[n][m];
        d[0][0] = a[0][0];
        for(int i = 1; i < n * m; i++){
            int x = i / m;
            int y = i % m;
            for(int k = 0; k < 3; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx >= 0 && ny >= 0) {
                    d[x][y] = Math.max(d[nx][ny], d[x][y]);
                }
            }
            d[x][y] += a[x][y];
        }
        System.out.println(d[n-1][m-1]);
    }
}
