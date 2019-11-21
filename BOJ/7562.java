import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main {
    static final int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
    static final int[] dy = {-2, -2, -1, 1, 2, 2, 1, -1};
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");
            int startX = Integer.parseInt(line1[0]);
            int startY = Integer.parseInt(line1[1]);
            int endX = Integer.parseInt(line2[0]);
            int endY = Integer.parseInt(line2[1]);
            int[][] dist = new int[n][n];
            boolean[][] check = new boolean[n][n];
            Queue<Pair> q = new LinkedList<Pair>();
            q.add(new Pair(startX, startY));
            check[startX][startY] = true;
            while(!q.isEmpty()){
                Pair p = q.remove();
                int x = p.x;
                int y = p.y;
                for(int k = 0; k < 8; k++){
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                        if(!check[nx][ny]) {
                            q.add(new Pair(nx, ny));
                            check[nx][ny] = true;
                            dist[nx][ny] = dist[x][y] + 1;
                        }
                    }
                }
            }
            System.out.println(dist[endX][endY]);
        }
    }
}
