import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int R, C;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

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

        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);

        board = new char[R][C];

        for(int i = 0; i < R; i++){
            String temp = br.readLine();
            for(int j = 0; j < C; j++)
                board[i][j] = temp.charAt(j);
        }

        int n = Integer.parseInt(br.readLine());

        int[] heights = new int[n];
        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            heights[i] = Integer.parseInt(s[i]);

        for(int i = 0; i < n; i++){
            visited = new boolean[R][C];
            int height = R - heights[i];
            int col;
            // 왼쪽에서 던짐
            if(i % 2 == 0) {
                col = 0;
                // 미네랄 발견되는 지점
                while (col < C && board[height][col] == '.')
                    col++;
                // 끝까지 미네랄이 없는 경우 다음 막대기로 넘어감
                if (col == C)
                    continue;
            }
            else {
                col = C - 1;
                // 미네랄 발견되는 지점
                while(col >= 0 && board[height][col] == '.')
                    col--;
                // 끝까지 미네랄이 없는 경우 다음 막대기로 넘어감
                if(col == -1)
                    continue;
            }
            // 미네랄 파괴
            board[height][col] = '.';
            // 파괴된 미네랄의 상하좌우 확인해서 파괴된 미네랄이 포함된 클러스터 찾기
            for(int k = 0; k < 4; k++){
                int nx = height + dx[k];
                int ny = col + dy[k];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(board[nx][ny] == 'x'){
                    // 파괴된 미네랄이 포함되어 있던 클러스터가 땅과 닿아있는지 확인
                    // 닿아있지 않은 경우에는 클러스터를 내려야 함
                    if(!bfs(nx, ny)){
                        Queue<Pair> removed = new LinkedList<>();
                        Queue<Pair> added = new LinkedList<>();
                        int min = Integer.MAX_VALUE;
                        // 클러스터가 얼마나 내려가야 하는지 측정
                        // 땅에서 가장 가까운 미네랄을 기준으로 내려감
                        for(col = 0; col < C; col++){
                            int sum = 0;
                            for(int row = R - 1; row >= 0; row--){
                                if(board[row][col] == '.')
                                    sum++;
                                else {
                                    if (visited[row][col]){
                                        min = Math.min(sum, min);
                                        break;
                                    }
                                    else
                                        sum = 0;
                                }
                            }
                        }
                        for(int row = 0; row < R; row++){
                            for(col = 0; col < C; col++){
                                if(visited[row][col]){
                                    removed.add(new Pair(row, col));
                                    added.add(new Pair(row + min, col));
                                }
                            }
                        }
                        for(Pair p : removed)
                            board[p.x][p.y] = '.';
                        for(Pair p : added)
                            board[p.x][p.y] = 'x';
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }

    }
    static boolean bfs(int x, int y){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited = new boolean[R][C];
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Pair p = queue.remove();
            for(int k = 0; k < 4; k++){
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(visited[nx][ny]) continue;
                if(board[nx][ny] == '.') continue;
                if(nx == R - 1) return true;
                visited[nx][ny] = true;
                queue.add(new Pair(nx, ny));
            }
        }
        return false;
    }
}
