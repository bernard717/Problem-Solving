import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int max, N;

    static int[][] board;

    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int T = 1; T <= test; T++){
            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);

            board = new int[N][N];

            int highest = -1;

            for(int i = 0; i < N; i++){
                line = br.readLine().split(" ");
                for(int j = 0; j < N; j++) {
                    int temp = Integer.parseInt(line[j]);
                    board[i][j] = temp;
                    highest = Math.max(highest, temp);
                }
            }

            // 가장 높은 봉우리의 좌표를 저장하는 ArrayList
            ArrayList<Pair> top = new ArrayList<>();

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(board[i][j] == highest)
                        top.add(new Pair(i, j));
                }
            }

            max = Integer.MIN_VALUE;
            boolean[][] visited;

            // 1부터 K까지 깎아보기
            for(int i = 1; i <= K; i++){
                for(int row = 0; row < N; row++){
                    for(int col = 0; col < N; col++){
                        // 현재 위치가 i보다 작으면 넘어감
                        if(board[row][col] < i) continue;
                        board[row][col] -= i;

                        // 시작점은 항상 가장 높은 봉우리
                        for(Pair p : top) {
                            // 방금 깎은 곳이 가장 높은 봉우리면 넘어감
                            //if(p.x == row && p.y == col) continue;
                            visited = new boolean[N][N];
                            visited[p.x][p.y] = true;
                            dfs(p.x, p.y, 1, visited);
                        }
                        board[row][col] += i;
                    }
                }

            }

            System.out.println("#" + T + " " + max);
        }
    }
    static void dfs(int x, int y, int depth, boolean[][] visited){
        boolean go = false;
        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visited[nx][ny]) continue;
            if(board[x][y] <= board[nx][ny]) continue;
            go = true;
            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, visited);
            visited[nx][ny] = false;
        }
        // 더 이상 갈 곳이 없을 경우
        if(!go)
            max = Math.max(max, depth);
    }
}
