import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int[][] board;
    static boolean[] check;
    static int ans = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[5][5];

        for(int i = 0; i < 5; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < 5; j++)
                board[i][j] = Integer.parseInt(line[j]);
        }

        // 새로 만든 숫자가 이미 있는지 확인하기 위한 배열
        check = new boolean[1000000];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++)
                dfs(i, j, 1, Integer.toString(board[i][j]));
        }

        System.out.print(ans);
    }
    static void dfs(int x, int y, int len, String line){
        if(len == 6){
            int num = Integer.parseInt(line);
            // 해당 숫자가 이미 만들어진 것인지 확인
            if(!check[num]) {
                ans++;
                check[num] = true;
            }
            return;
        }
        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx < 0 || ny < 0 || nx > 4 || ny > 4) continue;
            dfs(nx, ny, len + 1, line + board[nx][ny]);
        }
    }
}
