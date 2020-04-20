import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());

        // 친구 사이의 간선을 유지하는 연결리스트
        ArrayList<Integer>[] friends = new ArrayList[n];
        for(int i = 0; i < n; i++)
            friends[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            friends[a].add(b);
            friends[b].add(a);
        }

        int[] dist = new int[n];
        for(int i = 0; i < n; i++)
            dist[i] = -1;

        dist[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int now = queue.remove();
            for(int friend : friends[now]){
                if(dist[friend] != -1) continue;
                dist[friend] = dist[now] + 1;
                queue.add(friend);
            }
        }
        int ans = 0;
        for(int i = 1; i < n; i++){
            if(dist[i] != -1 && dist[i] <= 2)
                ans++;
        }
        System.out.print(ans);
    }
}
