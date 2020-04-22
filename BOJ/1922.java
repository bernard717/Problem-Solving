import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main{
    static class Edge implements Comparable<Edge>{
        int x, y, cost;
        public Edge(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            if(this.cost < o.cost)
                return -1;
            else
                return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] adj = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            if(x == y) continue;
            adj[x].add(new Edge(x, y, cost));
            adj[y].add(new Edge(y, x, cost));
        }

        // 해당 정점이 MST에 있는지 유지하는 배열
        boolean[] check = new boolean[n + 1];

        // 간선들을 집어넣는 우선순위큐
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 0번 점을 일단 MST에 포함시킴
        check[1] = true;
        for(Edge e : adj[1])
            pq.add(e);

        // MST에 들어간 간선 수
        int sum = 0;
        // 정답
        int ans = 0;

        while(true){
            Edge e = pq.remove();
            // 뽑은 간선의 정점 모두가 MST에 있는 경우는 넘어감
            if(check[e.x] && check[e.y]) continue;
            // MST에 포함되지 않은 정점
            int temp;
            if(!check[e.x])
                temp = e.x;
            else
                temp = e.y;

            check[temp] = true;
            sum++;
            ans += e.cost;
            // MST 완성여부 확인
            if(sum == n - 1)
                break;
            for(Edge now : adj[temp]){
                if(check[now.y]) continue;
                pq.add(now);
            }
        }
        System.out.print(ans);
    }
}
