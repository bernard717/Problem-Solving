class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    public void reverse(int[] a, int from, int to){
        int st = from;
        int en = to;
        while(st < en){
            int temp = a[st];
            a[st] = a[en];
            a[en] = temp;
            st++;
            en--;
        }
    }
}
