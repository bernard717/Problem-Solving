class Solution {
    public int search(int[] nums, int target) {
        int st = 0;
        int en = nums.length - 1;
        
        while(st <= en){
            int mid = (st + en) / 2;
            
            if(nums[mid] < target)
                st = mid + 1;
            else if(nums[mid] > target)
                en = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
