import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int m = Integer.parseInt(line[2]);

        // 정점 사이의 간선을 유지하는 연결리스트
        ArrayList<Integer>[] friends = new ArrayList[101001];
        for(int i = 0; i < 101001; i++)
            friends[i] = new ArrayList<>();

        int idx = n;
        for(int i = 0; i < m; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j < k; j++){
                int now = Integer.parseInt(line[j]) - 1;
                friends[idx].add(now);
                friends[now].add(idx);
            }
            idx++;
        }

        int[] dist = new int[101001];
        for(int i = 0; i < 101001; i++)
            dist[i] = -1;

        dist[0] = 1;
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
        int ans = dist[n - 1] == -1 ? -1 : (dist[n - 1] + 1) / 2;
        System.out.print(ans);
    }
}
