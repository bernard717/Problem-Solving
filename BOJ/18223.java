import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main{
    static ArrayList<Edge>[] adj;
    static final int MAX = 50000010;
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
        String[] line = br.readLine().split(" ");
        int vNum = Integer.parseInt(line[0]);
        int eNum = Integer.parseInt(line[1]);
        int kunwoo = Integer.parseInt(line[2]);

        adj = new ArrayList[vNum + 1];
        for(int i = 0; i <= vNum; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < eNum; i++){
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            adj[x].add(new Edge(y, cost));
            adj[y].add(new Edge(x, cost));
        }

        int[] d = new int[vNum + 1];
        for(int i = 0; i <= vNum; i++)
            d[i] = MAX;
        int[] pre = new int[vNum + 1];
        dijkstra(d, pre, 1, kunwoo);

        int cur = vNum;
        ArrayList<Integer> route = new ArrayList<>();
        while(cur != 1){
            route.add(cur);
            cur = pre[cur];
        }
        route.add(1);
        if(route.contains(kunwoo)){
            System.out.print("SAVE HIM");
        }
        else
            System.out.print("GOOD BYE");
    }
    static void dijkstra(int[] d, int[] pre, int start, int kunwoo){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, start));
        d[start] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            if(d[p.vertex] == p.distance){
                for(Edge e : adj[p.vertex]){
                    if(d[e.dst] > d[p.vertex] + e.cost || (d[e.dst] == d[p.vertex] + e.cost && p.vertex == kunwoo)){
                        d[e.dst] = d[p.vertex] + e.cost;
                        pre[e.dst] = p.vertex;
                        pq.add(new Pair(d[e.dst], e.dst));
                    }
                }
            }
        }
    }
}
