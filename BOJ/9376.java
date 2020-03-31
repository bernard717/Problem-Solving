import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int row, col, answer;
    static char[][] board;
    static boolean[][] visited;

    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int i = 0; i < test; i++){
            String[] s = br.readLine().split(" ");
            row = Integer.parseInt(s[0]);
            col = Integer.parseInt(s[1]);

            int x1 = -1, x2 = -1, y1 = -1, y2 = -1;

            answer = Integer.MAX_VALUE;


            // 전체 감옥의 모든 변에 한 줄씩 빈 칸 추가 - 외부에 있는 사람이 감옥으로 들어갈 때 어디로든 들어갈 수 있기 때문
            // 빈 공간을 지나갈 때는 dist값(지나간 문의 개수)이 늘지 않기 때문에 외부에 있는 사람은 어디서 출발해도 상관 없음
            board = new char[row + 2][col + 2];
            for(int j = 0; j < row + 2; j++){
                for(int k = 0; k < col + 2; k++)
                    board[j][k] = '.';
            }

            for(int j = 1; j <= row; j++){
                String temp = br.readLine();
                for(int k = 1; k <= col; k++){
                    char c = temp.charAt(k - 1);
                    if(c == '$'){
                        if(x1 == -1){
                            x1 = j;
                            y1 = k;
                        }
                        else{
                            x2 = j;
                            y2 = k;
                        }
                    }
                    board[j][k] = c;
                }
            }

            Deque<Pair> deque1 = new LinkedList<>();
            Deque<Pair> deque2 = new LinkedList<>();
            Deque<Pair> deque3 = new LinkedList<>();

            deque1.add(new Pair(x1, y1));
            deque2.add(new Pair(x2, y2));
            deque3.add(new Pair(0, 0));

            int[][] dist1 = new int[row + 2][col + 2];
            int[][] dist2 = new int[row + 2][col + 2];
            int[][] dist3 = new int[row + 2][col + 2];

            for(int j = 0; j < row + 2; j++){
                for(int k = 0; k < col + 2; k++) {
                    dist1[j][k] = -1;
                    dist2[j][k] = -1;
                    dist3[j][k] = -1;
                }
            }
            dist1[x1][y1] = 0;
            dist2[x2][y2] = 0;
            dist3[0][0] = 0;

            bfs(dist1, deque1);
            bfs(dist2, deque2);
            bfs(dist3, deque3);

            for(int j = 0; j < row + 2; j++){
                for(int k = 0; k < col + 2; k++){
                    if(board[j][ k] == '*') continue;
                    if(dist1[j][k] == -1 || dist2[j][k] == -1 || dist3[j][k] == -1) continue;
                    int sum = dist1[j][k] + dist2[j][k] + dist3[j][k];
                    if(board[j][k] == '#')
                        sum -= 2;
                    answer = Math.min(sum, answer);
                }
            }
            if(answer == Integer.MAX_VALUE)
                answer = 0;
            System.out.println(answer);
        }
    }
    static void bfs(int[][] dist, Deque<Pair> deque){
        while(!deque.isEmpty()){
            Pair p = deque.remove();
            int x = p.x;
            int y = p.y;
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || ny < 0 || nx >= row + 2 || ny >= col + 2) continue;
                if(board[nx][ny] == '*') continue;
                if(dist[nx][ny] != -1) continue;
                // 문을 지나면 dist에 +1
                // deque의 뒷부분에 삽입 - 문을 많이 통과할수록 우선순위가 낮기 때문 
                if(board[nx][ny] == '#'){
                    dist[nx][ny] = dist[x][y] + 1;
                    deque.addLast(new Pair(nx, ny));
                }
                // 문이 아닌 부분을 통과하면 dist 값은 그대로
                // deque의 앞부분에 삽입 - 문을 통과하지 않기 때문에 우선순위 높음
                else if(board[nx][ny] == '.' || board[nx][ny] == '$'){
                    dist[nx][ny] = dist[x][y];
                    deque.addFirst(new Pair(nx, ny));
                }
            }
        }
    }
}
