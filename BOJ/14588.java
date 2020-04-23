import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 10000;
        int n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n];

        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            points[i] = new Point(x, y);
        }

        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = max;
            }
            dist[i][i] = 0;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                Point a = points[i];
                Point b = points[j];
                if(b.y > a.y){
                    if(b.x <= a.y) {
                        dist[i][j] = 1;
                        dist[j][i] = 1;
                    }
                }
                else if(b.y == a.y){
                    dist[i][j] = 1;
                    dist[j][i] = 1;
                }
                else{
                    if(b.y >= a.x){
                        dist[i][j] = 1;
                        dist[j][i] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }

        int qNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < qNum; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]) - 1;
            int y = Integer.parseInt(line[1]) - 1;
            if(dist[x][y] == max)
                System.out.println(-1);
            else
                System.out.println(dist[x][y]);
        }
    }
}
