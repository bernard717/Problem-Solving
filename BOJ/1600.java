import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[] horsex = {-2, -2, -1, -1, 1, 1, 2, 2};
    public static int[] horsey = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static class Pair{
        int x, y, k;
        public Pair(int x, int y, int k){
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int horseMax = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        int col = Integer.parseInt(s[0]);
        int row = Integer.parseInt(s[1]);

        int[][] board = new int[row][col];

        for(int i = 0; i < row; i++){
            String[] temp = br.readLine().split(" ");
            for(int j = 0; j < col; j++)
                board[i][j] = Integer.parseInt(temp[j]);
        }


        int[][][] dist = new int[row][col][horseMax + 1];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                for(int k = 0; k < horseMax + 1; k++)
                    dist[i][j][k] = -1;
            }
        }
        dist[0][0][0] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 0));

        while(!queue.isEmpty()){
            Pair p = queue.remove();
            int x = p.x;
            int y = p.y;
            int k = p.k;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                if(dist[nx][ny][k] != -1) continue;
                if(board[nx][ny] == 1) continue;
                dist[nx][ny][k] = dist[x][y][k] + 1;
                queue.add(new Pair(nx, ny, k));
            }
            for(int i = 0; i < 8; i++){
                int nx = x + horsex[i];
                int ny = y + horsey[i];
                if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                if(k + 1 > horseMax || dist[nx][ny][k + 1] != -1) continue;
                if(board[nx][ny] == 1) continue;
                dist[nx][ny][k + 1] = dist[x][y][k] + 1;
                queue.add(new Pair(nx, ny, k + 1));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= horseMax; i++){
            if(dist[row - 1][col - 1][i] == -1) continue;
            min = Math.min(dist[row - 1][col - 1][i], min);
        }

        if(min == Integer.MAX_VALUE)
            System.out.print(-1);
        else
            System.out.print(min);
    }
}
