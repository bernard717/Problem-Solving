import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int row = Integer.parseInt(s[0]);
        int col = Integer.parseInt(s[1]);

        char[][] board = new char[row][col];

        int startX = 0, startY = 0, endX = 0, endY = 0;

        ArrayList<Pair> waters = new ArrayList<>();

        for(int i = 0; i < row; i++){
            String temp = br.readLine();
            for(int j = 0; j < col; j++) {
                char c = temp.charAt(j);
                if(c == 'S'){
                    startX = i;
                    startY = j;
                }
                else if(c == 'D'){
                    endX = i;
                    endY = j;
                }
                else if(c == '*'){
                    waters.add(new Pair(i, j));
                }
                board[i][j] = c;
            }
        }

        int[][] waterDist = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++)
                waterDist[i][j] = -1;
        }

        Queue<Pair> waterQueue = new LinkedList<>();
        for(Pair p : waters){
            waterQueue.add(p);
            waterDist[p.x][p.y] = 0;
        }
        while(!waterQueue.isEmpty()){
            Pair p = waterQueue.remove();
            int x = p.x;
            int y = p.y;
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                if(board[nx][ny] == 'D' || board[nx][ny] == 'X') continue;
                if(waterDist[nx][ny] != -1) continue;
                waterDist[nx][ny] = waterDist[x][y] + 1;
                waterQueue.add(new Pair(nx, ny));
            }
        }

        int[][] dist = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++)
                dist[i][j] = -1;
        }

        dist[startX][startY] = 0;

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(startX, startY));

        while(!queue.isEmpty()){
            Pair p = queue.remove();
            int x = p.x;
            int y = p.y;
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                if(board[nx][ny] == 'X' || board[nx][ny] == '*') continue;
                if(dist[nx][ny] != -1) continue;
                if((nx != endX || ny != endY) && waterDist[nx][ny] != -1 && dist[x][y] + 1 >= waterDist[nx][ny]) continue;
                dist[nx][ny] = dist[x][y] + 1;
                queue.add(new Pair(nx, ny));
            }
        }
        if(dist[endX][endY] == -1)
            System.out.print("KAKTUS");
        else
            System.out.print(dist[endX][endY]);

    }
}
