class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] map = new String[26];
        Set<String> set = new HashSet<>();
        
        String[] strs = str.split(" ");
        
        int len = strs.length;
        if(len != pattern.length())
            return false;
        
        for(int i = 0; i < len; i++){
            String now = strs[i];
            char c = pattern.charAt(i);
            if(map[c - 'a'] == null){
                if(set.contains(now))
                    return false;
                map[c - 'a'] = now;
            }
            else{
                if(!map[c - 'a'].equals(now))
                    return false;
            }
            set.add(now);
        }
        return true;
    }
}
