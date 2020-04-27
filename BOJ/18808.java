import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);

        boolean[][] notebook = new boolean[N][M];

        for(int i = 0; i < K; i++){
            line = br.readLine().split(" ");
            int R = Integer.parseInt(line[0]);
            int C = Integer.parseInt(line[1]);

            boolean[][] sticker = new boolean[R][C];
            for(int j = 0; j < R; j++){
                line = br.readLine().split(" ");
                for(int k = 0; k < C; k++)
                    sticker[j][k] = Integer.parseInt(line[k]) == 1;
            }
            int turned = 0;
            while(turned < 4 && !check(notebook, sticker, R, C)){
                sticker = rotate(sticker, R, C);
                int temp = R;
                R = C;
                C = temp;
                turned++;
            }
        }
        int sum = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(notebook[i][j])
                    sum++;
            }
        }
        System.out.print(sum);
    }
    static boolean[][] rotate(boolean[][] which, int row, int col){
        boolean[][] rotated = new boolean[col][row];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++)
                rotated[j][row - i - 1] = which[i][j];
        }
        return rotated;
    }
    static boolean check(boolean[][] notebook, boolean[][] sticker, int R, int C){
        boolean flag = false;
        for(int j = 0; j < N - R + 1; j++){
            for(int k = 0; k < M - C + 1; k++){
                flag = true;
                for(int row = 0; row < R; row++){
                    for(int col = 0; col < C; col++){
                        // 스티커가 들어갈 자리에 이미 노트북이 찬 경우
                        if(sticker[row][col] && notebook[j + row][k + col]){
                            flag = false;
                            break;
                        }
                    }
                    if(!flag)
                        break;
                }
                // 스티커가 들어갈 수 있다면 노트북에 스티커 붙임
                if(flag){
                    for(int row = 0; row < R; row++){
                        for(int col = 0; col < C; col++){
                            if(sticker[row][col])
                                notebook[j + row][k + col] = sticker[row][col];
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
