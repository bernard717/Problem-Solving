class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - 1;
        
        while(high - low + 1 > k){
            if(Math.abs(arr[high] - x) >= Math.abs(arr[low] - x))
                high--;
            else
                low++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = low; i <= high; i++)
            ans.add(arr[i]);
        
        return ans;
    }
}
