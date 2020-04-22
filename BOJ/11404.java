import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                dist[i][j] = (int) 1e9 + 10;
        }
        for(int i = 0; i < n; i++)
            dist[i][i] = 0;

        for(int i = 0; i < m; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]) - 1;
            int y = Integer.parseInt(line[1]) - 1;
            int cost = Integer.parseInt(line[2]);
            dist[x][y] = Math.min(dist[x][y], cost);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    dist[j][k] = Math.min(dist[j][i] + dist[i][k], dist[j][k]);
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(dist[i][j] == (int) 1e9 + 10)
                    dist[i][j] = 0;
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
