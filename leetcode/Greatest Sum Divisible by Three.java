class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        for(int num : nums){
            int[] temp = new int[3];
            
            for(int remainder = 0; remainder < 3; remainder++){
                temp[(num + remainder) % 3] = Math.max(dp[(num+remainder) % 3], dp[remainder] + num);
            }
            dp = temp;
        }
        
        return dp[0];
    }
}
