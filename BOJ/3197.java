import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int swanX1, swanX2, swanY1, swanY2;
    static int ans, R, C;
    static int[][] dist, dist2;
    static char[][] board;
    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);

        Queue<Pair> q = new LinkedList<>();
        dist = new int[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++)
                dist[i][j] = -1;
        }

        swanX1 = -1;
        swanX2 = -1;
        swanY1 = -1;
        swanY2 = -1;

        board = new char[R][C];
        for(int i = 0; i < R; i++){
            String line2 = br.readLine();
            for(int j = 0; j < C; j++) {
                char temp = line2.charAt(j);
                board[i][j] = temp;
                if(temp == '.' || temp == 'L') {
                    q.add(new Pair(i, j));
                    dist[i][j] = 0;
                }
                if(temp == 'L'){
                    if(swanX1 == -1){
                        swanX1 = i;
                        swanY1 = j;
                    }
                    else{
                        swanX2 = i;
                        swanY2 = j;
                    }
                }
            }
        }
        int max = -1;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(board[nx][ny] != 'X') continue;
                if(dist[nx][ny] != -1) continue;
                dist[nx][ny] = dist[x][y] + 1;
                max = Math.max(max, dist[nx][ny]);
                q.add(new Pair(nx, ny));
            }
        }

        ans = Integer.MAX_VALUE;

        binary_search(0, max);

        System.out.print(ans);


    }
    static void binary_search(int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(!bfs(mid))
                start = mid + 1;
            else {
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
        }
    }
    static boolean bfs(int days){
        dist2 = new int[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++) {
                dist2[i][j] = -1;
            }
        }
        dist2[swanX1][swanY1] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(swanX1, swanY1));
        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(dist2[nx][ny] != -1) continue;
                if(dist[nx][ny] > days) continue;
                dist2[nx][ny] = dist2[x][y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
        return dist2[swanX2][swanY2] != -1;
    }
}
