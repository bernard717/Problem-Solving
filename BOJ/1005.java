import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){
            String[] line = br.readLine().split(" ");
            // 건물 개수
            int n = Integer.parseInt(line[0]);
            // 건설 순서 규칙 개수
            int k = Integer.parseInt(line[1]);
            // 건물 건설에 걸리는 시간
            int[] time = new int[n + 1];
            line = br.readLine().split(" ");
            for(int i = 0; i < n; i++)
                time[i + 1] = Integer.parseInt(line[i]);

            ArrayList<Integer>[] adj = new ArrayList[n + 1];
            for(int i = 0; i <= n; i++)
                adj[i] = new ArrayList<>();

            int[] indegree = new int[n + 1];

            for(int i = 0; i < k; i++){
                line = br.readLine().split(" ");
                int front = Integer.parseInt(line[0]);
                int back = Integer.parseInt(line[1]);
                adj[front].add(back);
                indegree[back]++;
            }
            // 승리하기 위해 건설해야 하는 건물
            int goal = Integer.parseInt(br.readLine());

            int[] d = new int[n + 1];

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i <= n; i++){
                if(indegree[i] == 0) {
                    queue.add(i);
                    d[i] = time[i];
                }
            }
            while(!queue.isEmpty()){
                int temp = queue.remove();
                for(int now : adj[temp]){
                    indegree[now]--;
                    d[now] = Math.max(d[now], d[temp] + time[now]);
                    if(indegree[now] == 0)
                        queue.add(now);
                }
            }
            System.out.println(d[goal]);
        }
    }
}
