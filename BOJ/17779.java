import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int total = 0;
        int ans = Integer.MAX_VALUE;

        int[][] board = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(line[j - 1]);
                board[i][j] = temp;
                total += temp;
            }
        }

        int[] sum;

        for(int x = 1; x <= N; x++){
            for(int y = 1; y <= N; y++){
                for(int d1 = 1; d1 <= N; d1++){
                    for(int d2 = 1; d2 <= N; d2++){
                        if(x + d1 + d2 > N) continue;
                        if(y - d1 < 1) continue;
                        if(y + d2 > N) continue;
                        sum = new int[5];
                        // 1번 구역
                        for(int row = 1; row < x; row++){
                            for(int col = 1; col <= y; col++)
                                sum[0] += board[row][col];
                        }
                        for(int row = x; row <= x + d1 - 1; row++){
                            for(int col = 1; col <= x + y - 1 - row; col++)
                                sum[0] += board[row][col];
                        }
                        // 2번 구역
                        for(int row = 1; row <= x; row++){
                            for(int col = y + 1; col <= N; col++)
                                sum[1] += board[row][col];
                        }
                        for(int row = x + 1; row <= x + d2; row++){
                            for(int col = row - x + y + 1; col <= N; col++)
                                sum[1] += board[row][col];
                        }
                        // 3번 구역
                        for(int row = N; row >= x + d1 + d2; row--){
                            for(int col = 1; col <= y - d1 + d2 - 1; col++)
                                sum[2] += board[row][col];
                        }
                        for(int row = x + d1 + d2 - 1; row >= x + d1; row--){
                            for(int col = 1; col <= row - x + y - 2 * d1 - 1; col++)
                                sum[2] += board[row][col];
                        }
                        // 4번 구역
                        for(int row = N; row > x + d2 + d1; row--){
                            for(int col = y - d1 + d2; col <= N; col++)
                                sum[3] += board[row][col];
                        }
                        for(int row = x + d2 + d1; row >= x + d2 + 1; row--){
                            for(int col = x + y + 2 * d2 + 1 - row; col <= N; col++)
                                sum[3] += board[row][col];
                        }
                        sum[4] = total - (sum[0] + sum[1] + sum[2] + sum[3]);
                        Arrays.sort(sum);
                        ans = Math.min(ans, sum[4] - sum[0]);
                    }
                }
            }
        }
        System.out.print(ans);
    }
}
