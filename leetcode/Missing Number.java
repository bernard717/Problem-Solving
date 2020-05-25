class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int rightSum = len * (len + 1) / 2;
        
        int sum = 0;
        for(int i = 0; i < len; i++)
            sum += nums[i];
        
        return rightSum - sum;
    }
}
