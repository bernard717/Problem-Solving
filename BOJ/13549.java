import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static int[] dx = {-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        Deque<Integer> deque = new LinkedList<>();deque.add(n);

        int[] dist = new int[200001];
        for(int i = 0; i < 200001; i++)
            dist[i] = -1;

        int max = 200000;

        dist[n] = 0;

        while(!deque.isEmpty() && dist[k] == -1){
            int now = deque.getFirst();
            deque.removeFirst();
            if(now * 2 < max && dist[now * 2] == -1){
                dist[now * 2] = dist[now];
                deque.addFirst(now * 2);
            }
            for(int i = 0; i < 2; i++){
                int next = now + dx[i];
                if(next < 0 || next > max) continue;
                if(dist[next] != -1) continue;
                dist[next] = dist[now] + 1;
                deque.addLast(next);
            }
        }
        System.out.print(dist[k]);
    }
}
