class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        // indegree를 유지하는 배열
        int[] indegree = new int[n];

        // 각 정점에서 다른 정점으로 향하는 간선을 유지하는 배열
        ArrayList<Integer>[] arr = new ArrayList[n];
        for(int i = 0; i < n; i++)
            arr[i] = new ArrayList<>();
        
        int m = prerequisites.length;

        for(int i = 0; i < m; i++){
            int before = prerequisites[i][1];
            int after = prerequisites[i][0];
            
            indegree[after]++;
            arr[before].add(after);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0)
                queue.add(i);
        }
        
        int sum = 0;
        // 정답 저장하는 배열
        int[] ans = new int[n];
        while(!queue.isEmpty()){
            ans[sum] = queue.remove();
            for(int now : arr[ans[sum]]){
                indegree[now]--;
                if(indegree[now] == 0)
                    queue.add(now);
            }
            sum++;
        }
        if(sum != n)
            return new int[]{};
        
        return ans;
    }
}
