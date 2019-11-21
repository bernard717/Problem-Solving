import java.util.*;
class Solution {
    static ArrayList<Integer>[] arr;
    static int[] dist;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        arr = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for(int i = 1; i <= n; i++)
            arr[i] = new ArrayList<Integer>();
        
        for(int i = 0; i < edge.length; i++){
            arr[edge[i][0]].add(edge[i][1]);
            arr[edge[i][1]].add(edge[i][0]);
        }
        dist = new int[n + 1];
        
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int p = q.remove();
            for(int k : arr[p]){
                if(visited[k]) continue;
                visited[k] = true;
                dist[k] = dist[p] + 1;
                q.add(k);
            }
        }
        int max = -1;
        for(int i = 1; i <= n; i++)
            max = Math.max(max, dist[i]);
        for(int i = 1; i <= n; i++){
            if(dist[i] == max)
                answer++;
        }
        
        return answer;
    }
}
