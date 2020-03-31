import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        
        // 출발지와 목적지가 같을 때
        if(start == end){
            System.out.println(0);
            System.out.print(1);
            return;
        }

        int[] dist = new int[200001];
        int[] times = new int[200001];

        for(int i = 0; i < 200001; i++)
            dist[i] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while(!queue.isEmpty()){
            int now = queue.remove();
            // +1
            int nx = now + 1;
            if(nx <= 200000){
                // 방문한 적이 없으면 dist, times 배열에 새로운 값 넣음
                if(dist[nx] == -1) {
                    dist[nx] = dist[now] + 1;
                    times[nx]++;
                    queue.add(nx);
                }
                // 기존 dist값보다 작은 값이 생기면 dist값을 바꿔주고 times값도 다시 1로 설정
                else if(dist[nx] > dist[now] + 1) {
                    dist[nx] = dist[now] + 1;
                    times[nx] = 1;
                    queue.add(nx);
                }
                // 기존 dist값과 같은 값이면 times값을 추가(해당 dist의 가짓수를 증가시키는 것)
                else if(dist[nx] == dist[now] + 1) {
                    times[nx]++;
                    queue.add(nx);
                }
            }
            // -1
            nx = now - 1;
            if(nx >= 0){
                if(dist[nx] == -1) {
                    dist[nx] = dist[now] + 1;
                    times[nx]++;
                    queue.add(nx);
                }
                else if(dist[nx] > dist[now] + 1) {
                    dist[nx] = dist[now] + 1;
                    times[nx] = 1;
                    queue.add(nx);
                }
                else if(dist[nx] == dist[now] + 1) {
                    times[nx]++;
                    queue.add(nx);
                }
            }
            // *2
            nx = now * 2;
            if(nx <= 200000){
                if(dist[nx] == -1) {
                    dist[nx] = dist[now] + 1;
                    times[nx]++;
                    queue.add(nx);
                }
                else if(dist[nx] > dist[now] + 1) {
                    dist[nx] = dist[now] + 1;
                    times[nx] = 1;
                    queue.add(nx);
                }
                else if(dist[nx] == dist[now] + 1) {
                    times[nx]++;
                    queue.add(nx);
                }
            }
        }
        System.out.println(dist[end]);
        System.out.print(times[end]);
    }
}
