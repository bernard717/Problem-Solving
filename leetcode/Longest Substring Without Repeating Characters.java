class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int en = 0, st = 0; en < len; en++){
            if(map.containsKey(s.charAt(en))){
                st = Math.max(map.get(s.charAt(en)), st);
            }
            ans = Math.max(ans, en - st + 1);
            map.put(s.charAt(en), en + 1);
        }
        return ans;
    }
}
