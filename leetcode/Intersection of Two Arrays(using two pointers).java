class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int i = 0, j = 0;
        
        while(i < len1 && j < len2){
            if(nums1[i] < nums2[j])
                i++;
            
            else if(nums1[i] > nums2[j])
                j++;
            
            else{
                int n = nums1[i];
                int idx1 = i;
                while(idx1 < len1 && nums1[idx1] == nums1[i])
                    idx1++;
                
                int idx2 = j;
                while(idx2 < len2 && nums2[idx2] == nums2[j])
                    idx2++;
                
                int min = Math.min(idx1 - i, idx2 - j);
                
                while(min-- > 0)
                    arr.add(n);
                
                i = idx1;
                j = idx2;
            }
        }
        int[] ans = new int[arr.size()];
        
        for(i = 0; i < arr.size(); i++)
            ans[i] = arr.get(i);
            
        return ans;
    }
}
