import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        int[] costs = new int[41];
        for(int i = 1; i <= 40; i++)
            costs[i] = i * i + (i - 1) * (i - 1);

        for(int T = 1; T <= test; T++){
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            char[][] board = new char[n][n];

            for(int i = 0; i < n; i++){
                line = br.readLine().split(" ");
                for(int j = 0; j < n; j++)
                    board[i][j] = line[j].charAt(0);
            }

            int ans = Integer.MIN_VALUE;

            // k는 1부터 20까지의 값을 갖게 됨
            for(int k = 1; k <= n * 2; k++){
                // 운용비용
                int cost = costs[k];
                // 중앙지점은 (0, 0)부터 (n - 1, n - 1)
                for(int x = 0; x < n; x++){
                    for(int y = 0; y < n; y++){
                        // 서비스 제공 받는 집의 수
                        int sum = 0;
                        for(int j = -(k - 1); j < k; j++){
                            for(int i = -(k - Math.abs(j)) + 1; i < (k - Math.abs(j)); i++){
                                int nx = x + i;
                                int ny = y + j;
                                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                                if(board[x + i][y + j] == '1')
                                    sum++;
                            }
                        }
                        // 손해 보지 않는 경우
                        if(sum * m - cost >= 0)
                            ans = Math.max(sum, ans);
                    }
                }
            }

            System.out.println("#" + T + " " + ans);
        }
    }
}
