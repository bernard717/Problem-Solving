class Solution {
    public int maxSubArray(int[] nums) {
                
        int[] d = new int[nums.length];
        d[0] = nums[0];
        int max = d[0];
        
        for(int i = 1; i < nums.length; i++){
            d[i] = nums[i] + (d[i - 1] > 0 ? d[i - 1] : 0);
            max = Math.max(d[i], max);
        }
        
        return max;
    }
}
