import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int T = 1; T <= test; T++){
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];

            for(int i = 0; i < n; i++){
                String[] line = br.readLine().split(" ");
                for(int j = 0; j < n; j++)
                    board[i][j] = Integer.parseInt(line[j]);
            }
            // 정답 초기값은 -1
            int ans = -1;

            // 시작지점으로 전체 좌표를 확인
            for(int x = 0; x < n; x++){
                for(int y = 0; y < n; y++){
                    int leftMax = 0;
                    int rightMax = 0;
                    while(x - leftMax >= 0 && y + leftMax < n)
                        leftMax++;
                    while(x + rightMax < n && y + rightMax < n)
                        rightMax++;
                    // 대각선 지점으로 갈 수 없는 경우엔 불가능
                    if(leftMax <= 1 || rightMax <= 1)
                        continue;
                    for(int i = 1; i < leftMax; i++){
                        for(int j = 1; j < rightMax; j++){
                            // 해당 케이스에서 방문하는 디저트 종류
                            HashSet<Integer> kinds = new HashSet<>();
                            // 시작지점은 항상 들어감
                            kinds.add(board[x][y]);
                            // 이번 코스가 가능한지 확인하는 flag
                            boolean flag = true;
                            // 오른쪽 대각선 위(윗부분)
                            for(int k = 1; k <= i; k++){
                                // 이미 방문한 디저트 종류인 경우
                                if(kinds.contains(board[x - k][y + k])){
                                    flag = false;
                                    break;
                                }
                                kinds.add(board[x - k][y + k]);
                            }
                            if(!flag) continue;
                            // 오른쪽 대각선 아래(윗부분)
                            for(int k = 1; k <= j; k++){
                                // board 밖이거나 이미 방문한 디저트 종류인 경우
                                if(y + i + k >= n || kinds.contains(board[x - i + k][y + i + k])){
                                    flag = false;
                                    break;
                                }
                                kinds.add(board[x - i + k][y + i + k]);
                            }
                            if(!flag) continue;
                            // 오른쪽 대각선 아래(아랫부분)
                            for(int k = 1; k <= j; k++){
                                // 이미 방문한 디저트 종류인 경우
                                if(kinds.contains(board[x + k][y + k])){
                                    flag = false;
                                    break;
                                }
                                kinds.add(board[x + k][y + k]);
                            }
                            if(!flag) continue;
                            // 오른쪽 대각선 위(아랫부분)
                            for(int k = 1; k < i; k++){
                                // 이미 방문한 디저트 종류인 경우
                                if(kinds.contains(board[x + j - k][y + j + k])){
                                    flag = false;
                                    break;
                                }
                                kinds.add(board[x + j - k][y + j + k]);
                            }
                            if(!flag) continue;
                            // 조건 모두 만족하면 정답이 될 수 있음
                            ans = Math.max(ans, kinds.size());
                        }
                    }
                }
            }
            System.out.println("#" + T + " " + ans);
        }
    }
}
