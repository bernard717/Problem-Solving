class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int n, k;
    
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        
        for(k = 0; k < n + 1; k++){
            backtrack(0, new ArrayList<Integer>(), nums);
        }
                
        return ans;
    }
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums){
        if(curr.size() == k){
            ans.add(new ArrayList(curr));
            return;
        }
        for(int i = first; i < n; i++){
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
