import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int[] dx = {-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        int[] dist = new int[200001];
        int[] from = new int[200001];
        for(int i = 0; i < 200001; i++)
            dist[i] = -1;

        int max = 200000;

        dist[n] = 0;

        while(!queue.isEmpty() && dist[k] == -1){
            int now = queue.remove();
            if(now * 2 < max && dist[now * 2] == -1){
                dist[now * 2] = dist[now] + 1;
                from[now * 2] = now;
                queue.add(now * 2);
            }
            for(int i = 0; i < 2; i++){
                int next = now + dx[i];
                if(next < 0 || next > max) continue;
                if(dist[next] != -1) continue;
                dist[next] = dist[now] + 1;
                queue.add(next);
                from[next] = now;
            }
        }
        System.out.println(dist[k]);
        int[] answer = new int[dist[k] + 1];

        answer[answer.length - 1] = k;
        for(int i = answer.length - 2; i >= 0; i--){
            answer[i] = from[k];
            k = from[k];
        }
        for(int i = 0; i < answer.length; i++)
            System.out.print(answer[i] + " ");
    }
}
