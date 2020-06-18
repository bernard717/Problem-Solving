class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] cloneNum = nums.clone();
        
        Arrays.sort(cloneNum);
        
        int left = 0, right = nums.length - 1;
        
        while(left < nums.length && cloneNum[left] == nums[left])
            left++;
        
        while(right >= 0 && cloneNum[right] == nums[right])
            right--;
        
        return right - left > 0 ? right - left + 1 : 0;
    }
}
