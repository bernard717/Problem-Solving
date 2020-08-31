class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        return recur(dp, n);
    }
    public int recur(int[] dp, int n){
        if(dp[n] != 0)
            return dp[n];
        
        // 본인이 제곱수이면 1 반환
        int temp = (int)Math.floor(Math.sqrt(n));
        if(temp * temp == n){
            dp[n] = 1;
            return 1;
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = temp; n - i * i > 0 && i > 0; i--){
            int now = recur(dp, n - i * i) + 1;
            res = Math.min(now, res);
        }
        dp[n] = res;
        
        return res;
    }
}
