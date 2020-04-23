import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main{
    static final int MAX = 100000010;
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
        int vNum = Integer.parseInt(br.readLine());
        int eNum = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] routes = new ArrayList[vNum + 1];
        for(int i = 0; i <= vNum; i++)
            routes[i] = new ArrayList<>();

        for(int i = 0; i < eNum; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            routes[x].add(new Edge(y, cost));
        }

        String[] line = br.readLine().split(" ");
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // 처음에 시작점 넣음
        pq.add(new Pair(0, start));

        int[] d = new int[vNum + 1];
        for(int i = 0; i <= vNum; i++)
            d[i] = MAX;
        d[start] = 0;
        int[] pre = new int[vNum + 1];

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            if(d[p.vertex] == p.dist){
                for(Edge e : routes[p.vertex]){
                    if(d[e.dst] > d[p.vertex] + e.cost){
                        d[e.dst] = d[p.vertex] + e.cost;
                        pq.add(new Pair(d[e.dst], e.dst));
                        pre[e.dst] = p.vertex;
                    }
                }
            }
        }
        System.out.println(d[end]);
        ArrayList<Integer> passed = new ArrayList<>();
        int cur = end;
        while(cur != start){
            passed.add(cur);
            cur = pre[cur];
        }
        passed.add(start);
        System.out.println(passed.size());
        for(int i = passed.size() - 1; i >= 0; i--)
            System.out.print(passed.get(i) + " ");
    }
}
