class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int N = nums.length;
        for(int i = 0; i < N; i++){
            if(nums[i] == i + 1) continue;
            else{
                while(true){
                    int counter = nums[i] - 1;
                    if(nums[counter] == counter + 1)
                        break;
                    else{
                        int temp = nums[i];
                        nums[i] = nums[counter];
                        nums[counter] = temp;
                    }
                }
            }
        }
        for(int i = 0; i < N; i++){
            if(nums[i] != i + 1)
                list.add(i + 1);
        }
        return list;
    }
}
