class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = n - 1; i >= 0; i--)
            q.add(nums[i]);
        
        int cnt = k;
        while(cnt-- > 0)
            q.add(q.remove());
        
        for(int i = n - 1; i >= 0; i--)
            nums[i] = q.remove();
    }
}
