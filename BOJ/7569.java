import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
class Pair{
    int x, y, z;
    Pair(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Main {
    static int[][][] a, dist;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int m = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        int h = Integer.parseInt(line[2]);
        a = new int[m][n][h];
        dist = new int[m][n][h];
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                String[] line2 = br.readLine().split(" ");
                for(int k = 0; k < m; k++) {
                    a[k][j][i] = Integer.parseInt(line2[k]);
                    dist[k][j][i] = -1;
                    if(a[k][j][i] == 1){
                        q.add(new Pair(k, j, i));
                        dist[k][j][i] = 0;
                    }
                }
            }
        }
        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            for(int i = 0; i < 6; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if(nx < 0 || ny < 0 || nz < 0 || nx >= m || ny >= n || nz >= h) continue;
                if(a[nx][ny][nz] == 0 && dist[nx][ny][nz] == -1) {
                    dist[nx][ny][nz] = dist[x][y][z] + 1;
                    q.add(new Pair(nx, ny, nz));
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++){
                    if (dist[k][j][i] == -1 && a[k][j][i] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(dist[k][j][i], ans);
                }
            }
        }
        System.out.println(ans);
    }
}
