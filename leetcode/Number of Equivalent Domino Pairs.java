class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int[] d : dominoes){
            int now = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            map.put(now, map.getOrDefault(now, 0) + 1);
        }
        
        int ans = 0;
        for(int val : map.values())
            ans += val * (val - 1) / 2;
        
        return ans;
    }
}
