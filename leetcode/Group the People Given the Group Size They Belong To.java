class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) {
        int len = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < len; i++){
            int curr = arr[i];
            List<Integer> temp = new ArrayList<>();
            
            if(map.containsKey(curr))
                temp = map.get(curr);
            
            temp.add(i);
            map.put(curr, temp);
            
            if(temp.size() == curr){
                ans.add(temp);
                map.remove(curr);
            }
        }
        
        return ans;
    }
}
