class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ansX = -1, ansY = -1;
        
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                dp[i][j] = (j - i < 3 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
                if(dp[i][j]){
                    if(j - i > ansY - ansX || ansX == -1){
                        ansY = j;
                        ansX = i;
                    }
                }
            }
        }
        if(s.length() == 0)
            return s;
        return s.substring(ansX, ansY + 1);
    }
}
