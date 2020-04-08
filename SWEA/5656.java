import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int min = Integer.MAX_VALUE;
    static int W, H;
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
        int test = Integer.parseInt(br.readLine());

        for(int T = 1; T <= test; T++){
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            W = Integer.parseInt(line[1]);
            H = Integer.parseInt(line[2]);
            min = Integer.MAX_VALUE;

            int[][] board = new int[H][W];

            int bricks = 0;

            for(int i = 0; i < H; i++){
                line = br.readLine().split(" ");
                for(int j = 0; j < W; j++) {
                    int temp = Integer.parseInt(line[j]);
                    board[i][j] = temp;
                    if(temp != 0)
                        bricks++;
                }
            }

            dfs(N, 0, bricks, board);


            System.out.println("#" + T + " " + min);
        }
    }
    private static void dfs(int N, int depth, int left, int[][] board){
        if(depth == N || left == 0){
            min = Math.min(left, min);
            return;
        }
        for(int i = 0; i < W; i++){
            int row = -1;
            int col = i;
            for(int j = 0; j < H; j++){
                // 벽돌이 있을 때
                if(board[j][i] != 0) {
                    row = j;
                    break;
                }
            }
            // 벽돌이 끝까지 없을 경우 넘어감
            if(row == -1)
                continue;
            // 새로운 판으로 복사
            int[][] changed = new int[H][W];
            for(int j = 0; j < H; j++){
                for(int k = 0; k < W; k++)
                    changed[j][k] = board[j][k];
            }
            // 제거할 벽돌을 저장하는 hashset
            HashSet<Integer> hashSet = new HashSet<>();
            hashSet.add(row * W + col);
            // 각 벽돌이 제거할 대상을 추가할 때 bfs를 사용하기 위한 queue
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(row, col));
            while(!queue.isEmpty()){
                Pair p = queue.remove();
                int x = p.x;
                int y = p.y;
                int num = board[x][y];

                for(int k = 0; k < 4; k++){
                    for(int j = 1; j < num; j++){
                        int nx = x + dx[k] * j;
                        int ny = y + dy[k] * j;
                        if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                        if(board[nx][ny] == 0) continue;
                        if(hashSet.contains(nx * W + ny)) continue;
                        hashSet.add(nx * W + ny);
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
            // 제거된 벽돌 처리
            for(int where : hashSet){
                int x = where / W;
                int y = where % W;
                changed[x][y] = 0;
            }
            // 벽돌 아래에 빈 칸이 있는 경우 모두 아래로 내려줌
            clean(changed);
            dfs(N, depth + 1, left - hashSet.size(), changed);
        }
    }
    private static void clean(int[][] board){
        for(int i = 0; i < W; i++){
            int floor = H - 1;
            for(int j = H - 1; j >= 0; j--){
                if(board[j][i] != 0){
                    if(j != floor){
                        board[floor][i] = board[j][i];
                        board[j][i] = 0;
                    }
                    floor--;
                }
            }
        }
    }
}
