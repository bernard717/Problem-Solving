import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static ArrayList<Integer>[] kinds = new ArrayList[8];
    static ArrayList<Integer>[] directions = new ArrayList[4];

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

        // 각 터널 구조물 모양 별로 갈 수 있는 방향 모아두는 배열
        for(int i = 0; i < 8; i++)
            kinds[i] = new ArrayList<>();

        kinds[1].add(0);
        kinds[1].add(1);
        kinds[1].add(2);
        kinds[1].add(3);

        kinds[2].add(0);
        kinds[2].add(1);

        kinds[3].add(2);
        kinds[3].add(3);

        kinds[4].add(0);
        kinds[4].add(3);

        kinds[5].add(1);
        kinds[5].add(3);

        kinds[6].add(1);
        kinds[6].add(2);

        kinds[7].add(0);
        kinds[7].add(2);

        // 각 방향으로 이동했을 때 그 이동한 자리에 있어야 하는 터널 구조물 종류
        for(int i = 0; i < 4; i++)
            directions[i] = new ArrayList<>();

        directions[0].add(1);
        directions[0].add(2);
        directions[0].add(5);
        directions[0].add(6);

        directions[1].add(1);
        directions[1].add(2);
        directions[1].add(4);
        directions[1].add(7);

        directions[2].add(1);
        directions[2].add(3);
        directions[2].add(4);
        directions[2].add(5);

        directions[3].add(1);
        directions[3].add(3);
        directions[3].add(6);
        directions[3].add(7);

        for(int T = 1; T <= test; T++){
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            int startX = Integer.parseInt(line[2]);
            int startY = Integer.parseInt(line[3]);
            int L = Integer.parseInt(line[4]);

            int[][] board = new int[N][M];

            for(int i = 0; i < N; i++){
                line = br.readLine().split(" ");
                for(int j = 0; j < M; j++)
                    board[i][j] = Integer.parseInt(line[j]);
            }

            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(startX, startY));
            int[][] dist = new int[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++)
                    dist[i][j] = -1;
            }
            dist[startX][startY] = 0;

            while(!queue.isEmpty()){
                Pair p = queue.remove();
                for(int dir : kinds[board[p.x][p.y]]){
                    int nx = p.x + dx[dir];
                    int ny = p.y + dy[dir];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(board[nx][ny] == 0 || !directions[dir].contains(board[nx][ny])) continue;
                    if(dist[nx][ny] != -1) continue;
                    queue.add(new Pair(nx, ny));
                    dist[nx][ny] = dist[p.x][p.y] + 1;
                }
            }
            int ans = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(dist[i][j] != -1 && dist[i][j] < L)
                        ans++;
                }
            }

            System.out.println("#" + T + " " + ans);
        }
    }
}
