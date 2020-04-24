import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main{
    static ArrayList<Edge>[] adj;
    static final int MAX = 800010;
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

        line = br.readLine().split(" ");
        int passA = Integer.parseInt(line[0]);
        int passB = Integer.parseInt(line[1]);

        int[] d1 = new int[vNum + 1];
        int[] d2 = new int[vNum + 1];
        int[] d3 = new int[vNum + 1];
        for(int i = 0; i <= vNum; i++){
            d1[i] = MAX;
            d2[i] = MAX;
            d3[i] = MAX;
        }
        d1[1] = 0;
        d2[passA] = 0;
        d3[passB] = 0;

        dijkstra(d1, 1);
        dijkstra(d2, passA);
        dijkstra(d3, passB);

        int temp1 = d1[passA] + d2[passB] + d3[vNum];
        int temp2 = d1[passB] + d3[passA] + d2[vNum];
        if(temp1 >= MAX && temp2 >= MAX){
            System.out.print(-1);
        }
        else if(temp1 < temp2)
            System.out.print(temp1);
        else
            System.out.print(temp2);
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
