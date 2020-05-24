class Solution {
    public int trailingZeroes(int n) {
        int max = Integer.MAX_VALUE / 5;
        int st = 5;
        int res = 0;
        while(st <= n){
            res += n / st;
            if(st > max)
                return res;
            st *= 5;
        }
        return res;
    }
}
