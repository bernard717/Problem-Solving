import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main{
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static class Horse{
        int x, y, dir;
        public Horse(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j < n; j++)
                board[i][j] = Integer.parseInt(line[j]);
        }
        Horse[] horses = new Horse[k];
        for(int i = 0; i < k; i++){
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]) - 1;
            int y = Integer.parseInt(line[1]) - 1;
            int dir = Integer.parseInt(line[2]) - 1;
            horses[i] = new Horse(x, y, dir);
        }

        // 각 좌표별로 말의 순서대로 적어두는 보드
        ArrayList<Integer>[][] number = new ArrayList[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                number[i][j] = new ArrayList();
        }
        for(int i = 0; i < k; i++){
            Horse h = horses[i];
            number[h.x][h.y].add(i);
        }


        for(int turn = 1; turn <= 1000; turn++){
            // 각 말들에 대해 진행
            for(int i = 0; i < k; i++){
                Horse h = horses[i];
                // 원래 위치
                int nowX = h.x;
                int nowY = h.y;
                // 새로운 좌표
                int nx = h.x + dx[h.dir];
                int ny = h.y + dy[h.dir];
                // 새로운 좌표가 체스판 밖일 경우 또는 파란색인 경우
                if((nx < 0 || ny < 0 || nx >= n || ny >= n) || board[nx][ny] == 2){
                    // 반대 방향으로 새로운 좌표를 바꿈
                    if(h.dir % 2 == 0){
                        h.dir++;
                        nx = h.x + dx[h.dir];
                        ny = h.y + dy[h.dir];
                    }
                    else{
                        h.dir--;
                        nx = h.x + dx[h.dir];
                        ny = h.y + dy[h.dir];
                    }
                    // 만약 반대 방향으로 바꾼 좌표가 체스판 밖이거나 파란색인 경우
                    if((nx < 0 || ny < 0 || nx >= n || ny >= n) || board[nx][ny] == 2)
                        continue;
                    // 파란색이 아닌 경우는 빨간색이거나 흰색인 경우에 따라 달라짐
                }
                // 현재 말의 밑에서부터의 위치를 찾아냄
                int idx;
                for(idx = 0; idx < number[h.x][h.y].size(); idx++){
                    if(number[h.x][h.y].get(idx) == i)
                        break;
                }

                // 새로운 좌표가 흰색인 경우
                if(board[nx][ny] == 0){
                    // 현재 말과 그 위에 있는 말들을 큐에 집어넣음
                    Queue<Integer> queue = new LinkedList<>();
                    for(int temp = idx; temp < number[h.x][h.y].size(); temp++)
                        queue.add(number[h.x][h.y].get(temp));
                    while(!queue.isEmpty()) {
                        int out = queue.remove();
                        horses[out].x = nx;
                        horses[out].y = ny;
                        number[nx][ny].add(out);
                        // 새로운 좌표에 4개가 된 경우
                        if(number[nx][ny].size() == 4){
                            System.out.print(turn);
                            return;
                        }
                    }
                }
                // 새로운 좌표가 빨간색인 경우
                else{
                    Stack<Integer> stack = new Stack<>();
                    for(int temp = idx; temp < number[h.x][h.y].size(); temp++)
                        stack.push(number[h.x][h.y].get(temp));
                    while(!stack.isEmpty()) {
                        int out = stack.pop();
                        horses[out].x = nx;
                        horses[out].y = ny;
                        number[nx][ny].add(out);
                        // 새로운 좌표에 4개가 된 경우
                        if(number[nx][ny].size() == 4){
                            System.out.print(turn);
                            return;
                        }
                    }
                }
                // 새로운 좌표에 4개가 된 경우
                if(number[nx][ny].size() == 4){
                    System.out.print(turn);
                    return;
                }
                ArrayList<Integer> arrayList = new ArrayList<>();
                for(int r = 0; r < idx; r++)
                    arrayList.add(number[nowX][nowY].get(r));
                number[nowX][nowY] = arrayList;
                // 원래 위치가 4개가 된 경우
                if(number[nowX][nowY].size() == 4){
                    System.out.print(turn);
                    return;
                }
            }
        }
        System.out.print(-1);
    }

}
