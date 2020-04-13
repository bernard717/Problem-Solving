import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Microbe{
        int x, y, num, dir;
        public Microbe(int x, int y, int num, int dir){
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int T = 1; T <= test; T++){
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            int K = Integer.parseInt(line[2]);

            ArrayList<Microbe>[][] board = new ArrayList[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++)
                    board[i][j] = new ArrayList<Microbe>();
            }

            for(int i = 0; i < K; i++){
                line = br.readLine().split(" ");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                int num = Integer.parseInt(line[2]);
                int dir = Integer.parseInt(line[3]) - 1;
                board[x][y].add(new Microbe(x, y, num, dir));
            }

            int time = 0;
            while(time < M){
                // 새로운 자리로 가는 미생물을 보관하는 곳
                HashSet<Microbe> newSeat = new HashSet<>();
                for(int i = 0; i < N; i++){
                    for(int j = 0; j < N; j++){
                        // 해당 자리에 미생물이 없으면 넘어감
                        if(board[i][j].size() == 0) continue;
                        // 현재 위치의 미생물 확인
                        Microbe temp = board[i][j].get(0);
                        // 새 위치
                        int nx = temp.x + dx[temp.dir];
                        int ny = temp.y + dy[temp.dir];
                        newSeat.add(new Microbe(nx, ny, temp.num, temp.dir));
                        board[i][j].remove(0);
                    }
                }
                // 모든 미생물을 새로운 자리로 옮김
                for(Microbe m : newSeat){
                    // 새로운 자리가 약품 칠해진 구역일 경우
                    if(m.x == 0 || m.y == 0 || m.x == N - 1 || m.y == N - 1){
                        // 수는 반으로 줄이는데 0이면 그냥 사라짐
                        if(m.num / 2 == 0) continue;
                        // 방향 반대로 넣음
                        int dir = m.dir % 2 == 0 ? m.dir + 1 : m.dir - 1;
                        board[m.x][m.y].add(new Microbe(m.x, m.y, m.num / 2, dir));
                    }
                    // 새로운 자리가 일반 자리인 경우
                    else
                        board[m.x][m.y].add(new Microbe(m.x, m.y, m.num, m.dir));
                }
                // 모든 자리를 확인해서 여러 미생물 군집이 있는지 확인
                for(int i = 0; i < N; i++){
                    for(int j = 0; j < N; j++){
                        // 하나 이상의 군집이 있는 경우
                        if(board[i][j].size() > 1){
                            int sum = 0;
                            int max = board[i][j].get(0).num;
                            int dir = board[i][j].get(0).dir;
                            for(Microbe here : board[i][j]){
                                if(here.num > max){
                                    max = here.num;
                                    dir = here.dir;
                                }
                                sum += here.num;
                            }
                            board[i][j] = new ArrayList<>();
                            board[i][j].add(new Microbe(i, j, sum, dir));
                        }
                    }
                }
                time++;
            }
            int ans = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(board[i][j].size() != 0)
                        ans += board[i][j].get(0).num;
                }
            }

            System.out.println("#" + T + " " + ans);
        }
    }
}
