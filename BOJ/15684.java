import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static boolean[][] board ;
    static int N, M, H;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        H = Integer.parseInt(line[2]);

        board = new boolean[H + 1][N + 2];
        for(int i = 0; i < M; i++){
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            board[a][b] = true;
        }
        dfs(0, 1, true);
        if(ans == Integer.MAX_VALUE)
            ans = -1;
        System.out.print(ans);
    }
    static boolean game(){
        for(int col = 1; col <= N; col++){
            int row = 1;
            int temp = col;
            while(row <= H) {
                // 왼쪽에 가로선이 있는 경우
                if (temp > 1 && board[row][temp - 1])
                    temp--;
                else if (temp <= N + 1 && board[row][temp])
                    temp++;
                row++;
            }
            if(col != temp)
                return false;
        }
        return true;
    }
    static void dfs(int sum, int idx, boolean changed){
        if(sum > 3 || idx > N * H)
            return;
        if(changed && game()){
            ans = Math.min(ans, sum);
            return;
        }
        int row = (idx - 1) / N + 1;
        int col = idx % N;
        // 이번 위치에 이미 가로선이 있는 경우
        if(board[row][col])
            dfs(sum, idx + 1, false);
        else{
            board[row][col] = true;
            dfs(sum + 1, idx + 1, true);
            board[row][col] = false;
            dfs(sum , idx + 1, false);
        }
    }
}
