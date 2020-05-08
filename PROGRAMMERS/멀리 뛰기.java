class Solution {
    public long solution(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        long answer = 0;
        
        long prev2 = 1;
        long prev1 = 2;
        for(int i = 3; i <= n; i++){
            answer = prev2 + prev1;
            prev2 = prev1 % 1234567;
            prev1 = answer % 1234567;
        }
        
        return answer % 1234567;
    }
}
