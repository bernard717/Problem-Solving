import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int T = 1; T <= test; T++){
            int ans = 0;
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int len = Integer.parseInt(line[1]);

            int[][] board = new int[N][N];
            for(int i = 0; i < N; i++){
                line = br.readLine().split(" ");
                for(int j = 0; j < N; j++)
                    board[i][j] = Integer.parseInt(line[j]);
            }
            // 가로로 확인
            for(int i = 0; i < N; i++){
                int height = board[i][0];
                int nowLen = 1;
                boolean available = true;
                for(int j = 1; j < N; j++){
                    // 현재 높이와 같은 경우
                    if(board[i][j] == height)
                        nowLen++;
                    // 현재 높이보다 높은 경우
                    else if(board[i][j] == height + 1){
                        // 경사로보다 짧은 경우
                        if(nowLen < len) {
                            available = false;
                            break;
                        }
                        // 경사로보다 긴 경우
                        else{
                            height = board[i][j];
                            nowLen = 1;
                        }
                    }
                    // 현재 높이보다 낮은 경우
                    else if(board[i][j] == height - 1){
                        // 이 낮은 높이의 지형이 얼마나 지속되는지 확인
                        int temp = j;
                        while(temp < N && board[i][temp] == board[i][j])
                            temp++;
                        // 경사로 올릴 수 있는 거리와 경사로의 길이 비교
                        if(temp - j >= len){
                            if(temp < N) {
                                j += len - 1;
                                height = board[i][j];
                                nowLen = 0;
                            }
                            else
                                break;
                        }
                        else{
                            available = false;
                            break;
                        }
                    }
                    else{
                        available = false;
                        break;
                    }
                }
                if(available)
                    ans++;
            }
            // 세로로 확인
            for(int i = 0; i < N; i++){
                int height = board[0][i];
                int nowLen = 1;
                boolean available = true;
                for(int j = 1; j < N; j++){
                    // 현재 높이와 같은 경우
                    if(board[j][i] == height)
                        nowLen++;
                        // 현재 높이보다 높은 경우
                    else if(board[j][i] == height + 1){
                        // 경사로보다 짧은 경우
                        if(nowLen < len) {
                            available = false;
                            break;
                        }
                        // 경사로보다 긴 경우
                        else{
                            height = board[j][i];
                            nowLen = 1;
                        }
                    }
                    // 현재 높이보다 낮은 경우
                    else if(board[j][i] == height - 1){
                        // 이 낮은 높이의 지형이 얼마나 지속되는지 확인
                        int temp = j;
                        while(temp < N && board[temp][i] == board[j][i])
                            temp++;
                        // 경사로 올릴 수 있는 거리와 경사로의 길이 비교
                        if(temp - j >= len){
                            if(temp < N) {
                                j += len - 1;
                                height = board[j][i];
                                nowLen = 0;
                            }
                            else
                                break;
                        }
                        else{
                            available = false;
                            break;
                        }
                    }
                    else{
                        available = false;
                        break;
                    }
                }
                if(available)
                    ans++;
            }

            System.out.println("#" + T + " " + ans);
        }
    }

}
