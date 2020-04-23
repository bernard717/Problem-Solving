import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int party = Integer.parseInt(line[2]);
        int max = 1000000;

        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                dist[i][j] = max;
        }

        for(int i = 0; i < n; i++)
            dist[i][i] = 0;

        for(int i = 0; i < m; i++){
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]) - 1;
            int y = Integer.parseInt(line[1]) - 1;
            int cost = Integer.parseInt(line[2]);
            dist[x][y] = cost;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(dist[j][k] > dist[j][i] + dist[i][k]){
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.max(dist[i][party - 1] + dist[party - 1][i], ans);
        }
        System.out.print(ans);
    }
}
