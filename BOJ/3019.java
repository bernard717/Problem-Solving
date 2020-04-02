import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    static int[][] board;
    static boolean[] check;
    static int ans = 0;

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
        String[] line = br.readLine().split(" ");
        int C = Integer.parseInt(line[0]);
        int P = Integer.parseInt(line[1]);

        int highest = -1;
        int[] height = new int[C];

        line = br.readLine().split(" ");
        for(int i = 0; i < C; i++){
            int now = Integer.parseInt(line[i]);
            highest = Math.max(highest, now);
            height[i] = now;
        }

        // 전체 보드 높이는 highest에 1번 블록을 세로로 길게 놓은 값(4)을 더한 값
        int R = highest + 4;

        boolean[][] board = new boolean[R][C];

        // 높이에 맞게 보드 채움
        for(int i = 0; i < C; i++){
            int now = height[i];
            for(int j = 0; j < now; j++)
                board[R - 1 - j][i] = true;
        }

        int[][][] blockX = {{{0, 1, 2, 3}, {0, 0, 0, 0}}, {{0, 1, 0, 1}}, {{0, 0, 1, 1}, {0, 1, 1, 2}},
                {{0, 0, 1, 1}, {0, 1, 1, 2}}, {{0, 1, 1, 1}, {0, 1, 1, 2}, {0, 0, 0, 1}, {0, 1, 2, 1}},
                {{0, 1, 1, 1}, {0, 0, 1, 2}, {0, 0, 0, 1}, {0, 1, 2, 2}}, {{0, 1, 1, 1}, {0, 1, 2, 2}, {0, 0, 0, 1}, {0, 1, 2, 0}}};
        int[][][] blockY = {{{0, 0, 0, 0}, {0, 1, 2, 3}}, {{0, 0, 1, 1}}, {{1, 2, 0, 1}, {0, 0, 1, 1}},
                {{0, 1, 1, 2}, {1, 1, 0, 0}}, {{1, 0, 1, 2}, {1, 0, 1, 1}, {0, 1, 2, 1}, {0, 0, 0, 1}},
                {{2, 0, 1, 2}, {0, 1, 1, 1}, {0, 1, 2, 0}, {0, 0, 0, 1}}, {{0, 0, 1, 2}, {1, 1, 1, 0}, {0, 1, 2, 2}, {0, 0, 0, 1}}};

        int[][] usedX = blockX[P - 1];
        int[][] usedY = blockY[P - 1];

        int ans = 0;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                // 해당 지점이 이미 채워져있으면 pass
                if(board[i][j]) continue;
                for(int k = 0; k < usedX.length; k++){
                    // 조건 만족 여부
                    boolean flag = true;
                    ArrayList<Pair> temp = new ArrayList<>();
                    for(int m = 0; m < 4; m++){
                        int nx = i + usedX[k][m];
                        int ny = j + usedY[k][m];
                        // 블록이 들어갈 위치가 빈 곳이 아닌 경우 불가능
                        if(nx < 0 || ny < 0 || nx >= R || ny >= C || board[nx][ny]){
                            flag = false;
                            break;
                        }
                        temp.add(new Pair(nx, ny));
                    }
                    // 네 좌표 모두 조건을 만족한다면
                    if(flag){
                        // 네 좌표에 대해 블록 놓은 것으로 표시
                        for(Pair p : temp)
                            board[p.x][p.y] = true;
                        boolean tempFlag = true;
                        // 바닥으로부터 떨어진 블록이 있는지 확인
                        for(int t = 0; t < C; t++){
                            int row = R - height[t] - 1;
                            if(!board[row][t]){
                                while(row >= 0){
                                    if(board[row--][t]){
                                        tempFlag = false;
                                        break;
                                    }
                                }
                            }
                            if(!tempFlag)
                                break;
                        }
                        // 바닥으로부터 떨어진 블록이 없으면 정답에 1 추가
                        if(tempFlag)
                            ans++;
                        for(Pair p : temp)
                            board[p.x][p.y] = false;
                    }
                }
            }
        }
        System.out.print(ans);
    }
}
