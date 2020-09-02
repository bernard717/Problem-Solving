class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i <= k && i < n; i++){
            if(!set.add(nums[i]))
               return true;
        }
        for(int i = k + 1; i < n; i++){
            set.remove(nums[i - k - 1]);
            if(!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
