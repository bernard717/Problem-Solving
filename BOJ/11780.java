import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                dist[i][j] = 10000000;
        }
        for(int i = 0; i < n; i++)
            dist[i][i] = 0;

        int[][] next = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                next[i][j] = -1;
        }

        for(int i = 0; i < m; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]) - 1;
            int y = Integer.parseInt(line[1]) - 1;
            int cost = Integer.parseInt(line[2]);
            dist[x][y] = Math.min(dist[x][y], cost);
            next[x][y] = y;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(dist[j][k] > dist[j][i] + dist[i][k]){
                        dist[j][k] = dist[j][i] + dist[i][k];
                        next[j][k] = next[j][i];
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(dist[i][j] == 1000000)
                    dist[i][j] = 0;
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ArrayList<Integer> arr = new ArrayList<>();
                if(i == j){
                    System.out.println(0);
                    continue;
                }
                int cur = i;
                while(cur != j){
                    arr.add(cur);
                    cur = next[cur][j];
                }
                arr.add(j);
                System.out.print(arr.size());
                for(int e : arr)
                    System.out.print(" " + (e + 1));
                System.out.println();
            }
        }
    }
}
