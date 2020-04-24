import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Edge>[] adj;
    static final int MAX = 50000;
    static class Pair implements Comparable<Pair>{
        int distance, vertex;
        public Pair(int distance, int vertex){
            this.distance = distance;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.distance < o.distance)
                return -1;
            else
                return 1;
        }
    }
    static class Edge{
        int dst, cost;
        public Edge(int dst, int cost){
            this.dst = dst;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                return;
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++)
                    board[i][j] = Integer.parseInt(line[j]);
            }

            int vNum = n * n;

            adj = new ArrayList[vNum + 1];
            for (int i = 0; i <= vNum; i++)
                adj[i] = new ArrayList<>();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    int now = i * n + j;
                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        int temp = nx * n + ny;
                        adj[now].add(new Edge(temp, board[nx][ny]));
                    }
                }
            }

            int[] d = new int[vNum + 1];
            for (int i = 0; i <= vNum; i++)
                d[i] = MAX;
            dijkstra(d, 0);
            System.out.println("Problem " + idx + ": " + (d[n * n - 1] + board[0][0]));
            idx++;
        }

    }
    static void dijkstra(int[] d, int start){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, start));
        d[start] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            if(d[p.vertex] == p.distance){
                for(Edge e : adj[p.vertex]){
                    if(d[e.dst] > d[p.vertex] + e.cost){
                        d[e.dst] = d[p.vertex] + e.cost;
                        pq.add(new Pair(d[e.dst], e.dst));
                    }
                }
            }
        }
    }
}
