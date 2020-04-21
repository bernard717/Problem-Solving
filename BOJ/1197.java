import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main{
    static class Edge implements Comparable<Edge>{
        int x, y, cost;
        public Edge(int x, int y, int cost){
            if(x < y){
                this.x = x;
                this.y = y;
            }
            else {
                this.x = y;
                this.y = x;
            }
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
        int vertexNum = Integer.parseInt(line[0]);
        int edgeNum = Integer.parseInt(line[1]);

        ArrayList<Edge>[] adj = new ArrayList[vertexNum + 1];
        for(int i = 0; i <= vertexNum; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < edgeNum; i++){
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            adj[x].add(new Edge(x, y, cost));
            adj[y].add(new Edge(x, y, cost));
        }

        // 정점이 mst에 포함되어있는지 아닌지 확인하는 배열
        boolean[] check = new boolean[vertexNum + 1];

        // mst에 포함된 정점의 수
        int sum = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 정점 하나 임의로 선택
        check[1] = true;
        for(Edge e : adj[1])
            pq.add(e);

        int ans = 0;

        while(true){
            Edge temp = pq.poll();
            // 뽑은 간선의 정점 모두가 mst에 있으면 넘어감
            if(check[temp.x] && check[temp.y]) continue;
            ans += temp.cost;
            sum++;
            if(sum == vertexNum - 1)
                break;
            int vertex;
            if(!check[temp.x])
                vertex = temp.x;
            else
                vertex = temp.y;
            check[vertex] = true;
            if(adj[vertex].size() == 0) continue;
            for(Edge e : adj[vertex]) {
                if(!check[e.x] || !check[e.y])
                    pq.add(e);
            }
        }
        System.out.print(ans);
    }
}
