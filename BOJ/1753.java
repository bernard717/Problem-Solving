import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main{
    static final int MAX = 3000010;
    static class Edge{
        int dst, cost;
        public Edge(int dst, int cost){
            this.dst = dst;
            this.cost = cost;
        }
    }
    static class Pair implements Comparable<Pair>{
        int dist, vertex;
        public Pair(int dist, int vertex){
            this.dist = dist;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Pair that) {
            if(this.dist < that.dist)
                return -1;
            else
                return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int vNum = Integer.parseInt(line[0]);
        int eNum = Integer.parseInt(line[1]);

        int start = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] routes = new ArrayList[vNum + 1];
        for(int i = 0; i <= vNum; i++)
            routes[i] = new ArrayList<>();

        for(int i = 0; i < eNum; i++){
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            boolean flag = false;
            for(Edge e : routes[x]){
                if(e.dst == y){
                    if(e.cost > cost)
                        e.cost = cost;
                    flag = true;
                    break;
                }
            }
            if(!flag)
                routes[x].add(new Edge(y, cost));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // 처음에 시작점 넣음
        pq.add(new Pair(0, start));

        int[] d = new int[vNum + 1];
        for(int i = 0; i <= vNum; i++)
            d[i] = MAX;
        d[start] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            if(d[p.vertex] == p.dist){
                for(Edge e : routes[p.vertex]){
                    if(d[e.dst] > d[p.vertex] + e.cost){
                        d[e.dst] = d[p.vertex] + e.cost;
                        pq.add(new Pair(d[e.dst], e.dst));
                    }
                }
            }
        }
        for(int i = 1; i <= vNum; i++){
            if(d[i] == MAX)
                System.out.println("INF");
            else
                System.out.println(d[i]);
        }
    }
}
