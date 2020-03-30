import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int row, col;
    static int[][] board;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        row = Integer.parseInt(s[0]);
        col = Integer.parseInt(s[1]);

        board = new int[row][col];
        visited = new boolean[row][col];

        for(int i = 0; i < row; i++){
            String temp = br.readLine();
            for(int j = 0; j < col; j++)
                board[i][j] = temp.charAt(j) - '0';
        }

        solve(0, 0);
        System.out.print(max);
    }
    static void solve(int idx, int sum){
        if(idx == row * col){
            if(sum > max)
                max = sum;
            return;
        }
        int x = idx / col;
        int y = idx % col;
        if(visited[x][y]) {
            solve(idx + 1, sum);
            return;
        }
        int horizontal = check(idx, true);
        for(int len = horizontal; len >= 1; len--){
            int temp = 0;
            for(int i = 0; i < len; i++) {
                temp += board[x][y + i] * Math.pow(10, len - 1 - i);
                visited[x][y + i] = true;
            }
            solve(idx + 1, sum + temp);
            for(int i = 0; i < len; i++)
                visited[x][y + i] = false;
        }
        int vertical = check(idx, false);
        for(int len = vertical; len >= 1; len--){
            int temp = 0;
            for(int i = 0; i < len; i++) {
                temp += board[x + i][y] * Math.pow(10, len - 1 - i);
                visited[x + i][y] = true;
            }
            solve(idx + 1, sum + temp);
            for(int i = 0; i < len; i++)
                visited[x + i][y] = false;
        }
    }
    static int check(int idx, boolean horizontal){
        int x = idx / col;
        int y = idx % col;

        int tempX = x;
        int tempY = y;

        // 가로로 가장 먼 거리 반환
        if(horizontal){
            while(tempY < col && !visited[x][tempY])
                tempY++;
            return tempY - y;
        }
        // 세로로 가장 먼 거리 반환
        else{
            while(tempX < row && !visited[tempX][y])
                tempX++;
            return tempX - x;
        }
    }
}
