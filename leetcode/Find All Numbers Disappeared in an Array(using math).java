class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int N = nums.length;
        for(int i = 0; i < N; i++){
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0)
                nums[val] = - nums[val];
        }
        for(int i = 0; i < N; i++){
            if(nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }
}
