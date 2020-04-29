import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main{
    static int ans, N;
    static int[][] board;
    static boolean[][] visited;
    static int[] rotate = {2, 1, 4, 5, 6, 3};
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dir = {{-1, -1, 3, 2}, {1, 0, -1, -1}, {-1, 3, -1, 1}, {-1, 2, 1, -1}, {2, -1, 0, -1}, {3, -1, -1, 0}};
    static HashSet<Integer>[] hashSets;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            ans = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];

            for(int i = 0; i < N; i++){
                String[] line = br.readLine().split(" ");
                for(int j = 0; j < N; j++)
                    board[i][j] = Integer.parseInt(line[j]);
            }
            visited = new boolean[N][N];

            hashSets = new HashSet[4];
            for(int i = 0; i < 4; i++)
                hashSets[i] = new HashSet<>();

            hashSets[0].add(2);
            hashSets[0].add(5);
            hashSets[0].add(6);

            hashSets[1].add(2);
            hashSets[1].add(3);
            hashSets[1].add(4);

            hashSets[2].add(1);
            hashSets[2].add(4);
            hashSets[2].add(5);

            hashSets[3].add(1);
            hashSets[3].add(3);
            hashSets[3].add(6);

            visited[0][0] = true;
            dfs(1, 1, 2);

            System.out.println("#" + t + " " + ans);
        }
    }
    static void dfs(int len, int now, int before){
        // 마지막 위치일 때
        if(now == N * N - 1){
            if(before == 2 && (board[now / N][now % N] == 1 || board[now / N][now % N] == 2))
                ans = Math.min(ans, len + 1);
            else if(before == 0 && board[now / N][now % N] == 6){
                ans = Math.min(ans, len + 1);
            }
            return;
        }
        int row = now / N;
        int col = now % N;
        int pipe = board[row][col];

        // 현재 pipe 번호와 이전 위치에 따라 다음 위치 선정 가능
        for(int pipeNum : hashSets[before]) {
            if(pipe == 1 || pipe == 2) {
                if(pipeNum == 1 || pipeNum == 2)
                    go(row, col, pipeNum, before, len);
            }
            else {
                if(pipeNum != 1 && pipeNum != 2)
                    go(row, col, pipeNum, before, len);
            }
        }
    }

    static boolean inArea(int row, int col){
        if(row < 0 || col < 0 || row >= N || col >= N)
            return false;
        return true;
    }
    static void go(int row, int col, int pipe, int before, int len){
        // 현재 pipe 번호와 이전 위치에 따라 다음 위치 선정 가능
        int nextDir = dir[pipe - 1][before];
        int nx = row + dx[nextDir];
        int ny = col + dy[nextDir];
        int beforeDir = nextDir % 2 == 0 ? nextDir + 1 : nextDir - 1;
        if(inArea(nx, ny) && board[nx][ny] != 0 && !visited[nx][ny]) {
            visited[nx][ny] = true;
            dfs(len + 1, nx * N + ny, beforeDir);
            visited[nx][ny] = false;
        }
    }
}
