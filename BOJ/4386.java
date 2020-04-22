import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{
    static class Edge implements Comparable<Edge>{
        int x, y;
        double cost;
        public Edge(int x, int y, double cost){
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
    static class Point{
        double x, y;
        public Point(double x, double y){
            this.x = x; 
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n];

        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            double x = Double.parseDouble(line[0]);
            double y = Double.parseDouble(line[1]);
            points[i] = new Point(x, y);
        }

        // 해당 정점이 MST에 있는지 유지하는 배열
        boolean[] check = new boolean[n];

        // 간선들을 집어넣는 우선순위큐
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 0번 점을 일단 MST에 포함시킴
        check[0] = true;
        for(int i = 1; i < n; i++)
            pq.add(new Edge(0, i, dist(points[0].x, points[0].y, points[i].x, points[i].y)));

        // MST에 들어간 간선 수
        int sum = 0;
        // 정답
        double ans = 0;

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
            for(int i = 0; i < n; i++){
                if(check[i]) continue;
                pq.add(new Edge(temp, i, dist(points[temp].x, points[temp].y, points[i].x, points[i].y)));
            }
        }
        System.out.print(ans);
    }
    static double dist(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
