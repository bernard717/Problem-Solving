class Solution {
    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        
        return binary_search(x);
    }
    public int binary_search(int x){
        int st = 1;
        int en = x;
        
        while(st <= en){
            int mid = st + (en - st) / 2;
            if(mid < x / mid){
                st = mid + 1;
            }
            else if(mid > x / mid)
                en = mid - 1;
            else
                return mid;
        }
        return (st + en) / 2;
    }
}
