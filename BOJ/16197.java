import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] board;
    static int row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        row = Integer.parseInt(line[0]);
        col = Integer.parseInt(line[1]);

        board = new char[row][col];

        int x1 = -1, x2 = -1, y1 = -1, y2 = -1;

        for(int i = 0; i < row; i++){
            String s = br.readLine();
            for(int j = 0; j < col; j++){
                char c = s.charAt(j);
                if(c == 'o'){
                    if(x1 == -1){
                        x1 = i;
                        y1 = j;
                    }
                    else{
                        x2 = i;
                        y2 = j;
                    }
                }
                board[i][j] = c;
            }
        }

        dfs(x1, y1, x2, y2, 0);
        if(min == Integer.MAX_VALUE)
            min = -1;
        System.out.print(min);
    }
    static void dfs(int x1, int y1, int x2, int y2, int depth){
        if(depth >= 10)
            return;

        for(int k = 0; k < 4; k++){
            int nx1 = x1 + dx[k];
            int ny1 = y1 + dy[k];

            int nx2 = x2 + dx[k];
            int ny2 = y2 + dy[k];

            boolean coinOut1 = false;
            boolean coinOut2 = false;

            // 동전1이 밖으로 나가는 경우
            if(nx1 < 0 || ny1 < 0 || nx1 >= row || ny1 >= col) coinOut1 = true;

            // 동전1이 밖으로 나가는 경우
            if(nx2 < 0 || ny2 < 0 || nx2 >= row || ny2 >= col) coinOut2 = true;

            // 동전 하나만 나가는 경우 최솟값과 비교 후 종료
            if((coinOut1 && !coinOut2) || (!coinOut1 && coinOut2)){
                min = Math.min(depth + 1, min);
                return;
            }
            // 동전 모두 나가는 경우 다른 경로 탐색
            if(coinOut1 && coinOut2)
                continue;


            // 동전이 밖으로 나가지 않는 경우
            // 새로운 지점이 벽인 경우
            if(board[nx1][ny1] == '#') {
                nx1 = x1;
                ny1 = y1;
            }
            if(board[nx2][ny2] == '#') {
                nx2 = x2;
                ny2 = y2;
            }
            dfs(nx1, ny1, nx2, ny2, depth + 1);
        }

    }
}
