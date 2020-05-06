class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0)
                swap(idx++, i, nums);
        }
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
