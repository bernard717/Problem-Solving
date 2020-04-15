import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int ans, N, M, max;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int T = 1; T <= test; T++){
            ans = Integer.MIN_VALUE;
            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            M = Integer.parseInt(line[1]);
            max = Integer.parseInt(line[2]);

            board = new int[N][N];
            for(int i = 0; i < N; i++){
                line = br.readLine().split(" ");
                for(int j = 0; j < N; j++)
                    board[i][j] = Integer.parseInt(line[j]);
            }
            for(int i = 0; i <= N * N - M * 2; i++){
                int row1 = i / N;
                int col1 = i % N;
                if(col1 + M - 1 >= N) continue;
                for(int j = i + M; j <= N * N - M; j++){
                    int row2 = j / N;
                    int col2 = j % N;
                    if(col2 + M - 1 >= N) continue;
                    ans = Math.max(ans, calc(row1, col1) + calc(row2, col2));
                }
            }
            System.out.println("#" + T + " " + ans);
        }
    }
    static int calc(int x, int y){
        int tempMax = -1;
        int sum;
        for(int i = (int)Math.pow(2, M) - 1; i >= 0; i--){
            sum = 0;
            for(int j = 0; j < M; j++){
                if((i & 1 << j) == (1 << j))
                    sum += board[x][y + j];
            }
            if(sum <= max){
                sum = 0;
                for(int j = 0; j < M; j++){
                    if((i & 1 << j) == (1 << j))
                        sum += board[x][y + j] * board[x][y + j];
                }
                tempMax = Math.max(sum, tempMax);
            }
        }
        return tempMax;
    }
}
