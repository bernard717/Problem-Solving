import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Edge implements Comparable<Edge>{
        int x, y, cost;
        public Edge(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge that) {
            if(this.cost < that.cost)
                return -1;
            else
                return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int row = Integer.parseInt(line[0]);
        int col = Integer.parseInt(line[1]);

        int[][] board = new int[row][col];
        for(int i = 0; i < row; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j < col; j++)
                board[i][j] = Integer.parseInt(line[j]);
        }

        // 섬의 번호
        int idx = 0;
        // 섬의 번호 별로 포함하는 좌표들
        ArrayList<Pair>[] islands = new ArrayList[6];
        for(int i = 0; i < 6; i++)
            islands[i] = new ArrayList<>();

        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int temp = board[i][j];
                if(temp == 0) continue;
                if(visited[i][j]) continue;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, j));
                islands[idx].add(new Pair(i, j));
                board[i][j] = idx + 1;
                while(!q.isEmpty()){
                    Pair p = q.remove();
                    int x = p.x;
                    int y = p.y;
                    for(int k = 0; k < 4; k++){
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                        if(board[nx][ny] == 0) continue;
                        if(visited[nx][ny]) continue;
                        q.add(new Pair(nx, ny));
                        visited[nx][ny] = true;
                        islands[idx].add(new Pair(nx, ny));
                        board[nx][ny] = idx + 1;
                    }
                }
                idx++;
            }
        }

        ArrayList<Edge>[] adj = new ArrayList[idx];
        for(int i = 0; i < idx; i++)
            adj[i] = new ArrayList<>();

        // 각 섬 사이의 거리를 계산해서 저장
        for(int i = 0; i < idx; i++){
            int start = i + 1;
            for(Pair p : islands[i]){
                for(int k = 0; k < 4; k++){
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    int len = 0;
                    while(nx >= 0 && ny >= 0 && nx < row && ny < col && board[nx][ny] != start){
                        if(board[nx][ny] != 0){
                            adj[i].add(new Edge(i, board[nx][ny] - 1, len));
                            break;
                        }
                        nx += dx[k];
                        ny += dy[k];
                        len++;
                    }
                }
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] check = new boolean[idx];

        int i;
        for(i = 0; i < idx; i++) {
            if (adj[i].size() != 0)
                break;
        }
        if(idx == i){
            System.out.print(-1);
            return;
        }
        check[i] = true;
        for(Edge e : adj[i])
            pq.add(e);
        // 간선 수
        int sum = 0;
        // 정답
        int ans = 0;

        while(!pq.isEmpty()){
            Edge e = pq.remove();
            if(e.cost < 2) continue;
            if(check[e.x] && check[e.y]) continue;
            int temp;
            if(check[e.x])
                temp = e.y;
            else
                temp = e.x;
            check[temp] = true;
            ans += e.cost;
            sum++;
            if(sum == idx - 1)
                break;

            for(Edge now : adj[temp]){
                if(check[now.y]) continue;
                pq.add(now);
            }
        }
        if(sum != idx - 1)
            ans = -1;

        System.out.print(ans);
    }
}
