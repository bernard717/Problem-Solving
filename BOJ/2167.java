import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = {0, -1};
    static int[] dy = {-1, 0};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[][] a = new int[n][m];
        int[] d = new int[n * m];
        for(int i = 0; i < n; i++){
            String[] line2 = br.readLine().split(" ");
            for(int j = 0; j < m; j++)
                a[i][j] = Integer.parseInt(line2[j]);
        }
        d[0] = a[0][0];
        for(int i = 1; i < m * n; i++){
            int x = i / m;
            int y = i % m;
            if(x - 1 >= 0)
                d[i] += d[(x - 1) * m + y];
            if(y - 1 >= 0)
                d[i] += d[x * m + y - 1];
            if(x - 1 >= 0 && y - 1 >= 0)
                d[i] -= d[(x - 1) * m + y - 1];
            d[i] += a[x][y];
        }
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0){
            String[] line3 = br.readLine().split(" ");
            int x = Integer.parseInt(line3[0]) - 1;
            int y = Integer.parseInt(line3[1]) - 1;
            int nx = Integer.parseInt(line3[2]) - 1;
            int ny = Integer.parseInt(line3[3]) - 1;
            int ans = d[nx * m + ny];
            if(x - 1 >= 0)
                ans -= d[(x - 1) * m + ny];
            if(y - 1 >= 0)
                ans -= d[nx * m + y - 1];
            if(x - 1 >= 0 && y - 1 >= 0)
                ans += d[(x - 1) * m + y - 1];
            System.out.println(ans);
        }
    }
}
