class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 배열의 앞 두 값의 합을 통해 비교하는 min-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        List<List<Integer>> ans = new ArrayList();
        
        int len1 = nums1.length, len2 = nums2.length;
        if(len1 == 0 || len2 == 0) 
            return ans;
        
        // 처음에는 nums1의 모든 값과 nums2의 첫 번째 값을 pq에 넣음
        for(int i = 0; i < Math.min(k, len1); i++){
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        while(k-- > 0 && !pq.isEmpty()){
            int[] curr = pq.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(curr[0]);
            tmp.add(curr[1]);
            ans.add(tmp);
            
            // nums2의 idx가 끝에 달하면 pq에 남은 걸 계속 활용
            if(curr[2] + 1 == len2) continue;
            
            pq.offer(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
        }
        return ans;
    }
}
