class Solution {
    public int[] runningSum(int[] nums) {
        int i = 1;
        
      // memory 사용 O(1)
        while(i < nums.length){
            nums[i] += nums[i - 1];
            i++;
        }
        
        return nums;
    }
}
