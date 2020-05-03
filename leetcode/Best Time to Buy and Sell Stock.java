class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int now = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(now < prices[i])
                max = Math.max(max, prices[i] - now);
            else if(now > prices[i])
                now = prices[i];
        }
        return max;
    }
}
