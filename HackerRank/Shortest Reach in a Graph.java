import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int query = Integer.parseInt(br.readLine());
        for(int i = 0; i < query; i++){
            String[] line = br.readLine().split(" ");
            int nodeNum = Integer.parseInt(line[0]);
            int edgeNum = Integer.parseInt(line[1]);

            ArrayList<Integer>[] adj = new ArrayList[nodeNum + 1];
            for(int j = 0; j <= nodeNum; j++)
                adj[j] = new ArrayList<>();

            for(int j = 0; j < edgeNum; j++){
                line = br.readLine().split(" ");
                int from = Integer.parseInt(line[0]);
                int to = Integer.parseInt(line[1]);
                adj[from].add(to);
                adj[to].add(from);
            }

            int starting = Integer.parseInt(br.readLine());

            int[] dist = new int[1001];
            for(int j = 0; j < 1001; j++)
                dist[j] = -1;
            dist[starting] = 0;

            Queue<Integer> q = new LinkedList<>();
            q.add(starting);
            while(!q.isEmpty()){
                int now = q.remove();
                for(int next : adj[now]){
                    if(dist[next] != -1) continue;
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
            for(int j = 1; j <= nodeNum; j++){
                if(starting == j)
                    continue;
                int temp = dist[j] == -1 ? dist[j] : dist[j] * 6;
                System.out.print(temp + " ");
            }
            System.out.println();
        }
       
    }
}
