public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int cnt = 32;
        while(cnt-- > 0){
            result <<= 1;
            if((n & 1) == 1){
                result++;
            }
            n >>= 1;
        }
        return result;
    }
}
