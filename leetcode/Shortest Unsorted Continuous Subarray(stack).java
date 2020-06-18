class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int left = nums.length, right = 0;
        for(int i = 0; i < nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i])
                left = Math.min(left, st.pop());
            st.push(i);
        }
        st.clear();
        for(int i = nums.length - 1; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i])
                right = Math.max(right, st.pop());
            st.push(i);
        }
        
        return right - left > 0 ? right - left + 1 : 0;
    }
}
