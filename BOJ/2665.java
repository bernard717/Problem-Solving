import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main{
    static int MAX = 250000;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Edge{
        int dst, cost;
        public Edge(int dst, int cost){
            this.dst = dst;
            this.cost = cost;
        }
    }
    static class Road implements Comparable<Road>{
        int dist, dst;
        public Road(int dist, int dst){
            this.dist = dist;
            this.dst = dst;
        }

        @Override
        public int compareTo(Road o) {
            if(this.dist < o.dist)
                return -1;
            else
                return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++)
                board[i][j] = line.charAt(j) - '0';
        }

        int end = -1;

        // 흰 방 그룹별로 좌표 모음
        ArrayList<Pair>[] whites = new ArrayList[2501];
        for(int i = 0; i <= 2500; i++)
            whites[i] = new ArrayList<>();

        // 전체 좌표에 대해 흰 방 그룹으로 나눔
        boolean[][] visited = new boolean[n][n];

        int idx = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) continue;
                if(board[i][j] != 1) continue;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, j));
                visited[i][j] = true;
                board[i][j] = idx;
                whites[idx].add(new Pair(i, j));
                if(i == n - 1 && j == n - 1)
                    end = idx;
                while(!q.isEmpty()){
                    Pair p = q.remove();
                    int x = p.x;
                    int y = p.y;
                    for(int k = 0; k < 4; k++){
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if(board[nx][ny] == 0) continue;
                        if(visited[nx][ny]) continue;
                        q.add(new Pair(nx, ny));
                        visited[nx][ny] = true;
                        // 같은 흰 방 그룹은 같은 번호 매김
                        board[nx][ny] = idx;
                        whites[idx].add(new Pair(nx, ny));
                        if(nx == n - 1 && ny == n - 1)
                            end = idx;
                    }
                }
                idx++;
            }
        }
        // 흰 방 그룹 개수(1번에서 idx번까지)
        idx--;

        // 각 그룹에서 다른 그룹까지 가는 간선을 저장하는 배열
        ArrayList<Edge>[] adj = new ArrayList[idx + 1];
        for(int i = 0; i <= idx; i++)
            adj[i] = new ArrayList<>();

        // 각 그룹에서 다른 그룹까지 갈 때 거쳐야 하는 검은 방 개수 확인
        for(int i = 1; i <= idx; i++){
            Queue<Pair> q = new LinkedList<>();
            int[][] dist = new int[n][n];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++)
                    dist[j][k] = -1;
            }
            for(Pair p : whites[i]){
                q.add(p);
                dist[p.x][p.y] = 0;
            }
            while(!q.isEmpty()){
                Pair p = q.remove();
                for(int k = 0; k < 4; k++){
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if(board[nx][ny] == i) continue;
                    if(dist[nx][ny] != -1) continue;
                    dist[nx][ny] = dist[p.x][p.y] + 1;
                    if(board[nx][ny] != 0)
                        adj[i].add(new Edge(board[nx][ny], dist[nx][ny] - 1));
                    q.add(new Pair(nx, ny));
                }
            }
        }
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.add(new Road(0, 1));
        int[] d = new int[idx + 1];
        for(int i = 0; i <= idx; i++)
            d[i] = MAX;
        d[1] = 0;
        while(!pq.isEmpty()){
            Road r = pq.remove();
            if(d[r.dst] == r.dist){
                for(Edge e : adj[r.dst]){
                    if(e.cost + d[r.dst] < d[e.dst]){
                        d[e.dst] = e.cost + d[r.dst];
                        pq.add(new Road(d[e.dst], e.dst));
                    }
                }
            }
        }
        System.out.print(d[end]);
    }
}
