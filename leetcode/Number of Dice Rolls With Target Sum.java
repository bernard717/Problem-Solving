class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d + 1][Math.max(f, target) + 1];
        int mod = 1000000007;
        
        for(int i = 1; i <= f; i++)
            dp[1][i] = 1;
        
        for(int i = 2; i <= d; i++){
            for(int j = 2; j <= target; j++){
                for(int k = 1; k <= f && k < j; k++){
                    if(dp[1][k] != 0){
                        dp[i][j] += dp[i - 1][j - k];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        return dp[d][target];
    }
}
