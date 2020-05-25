class Solution {
    public int firstUniqChar(String s) {
        if(s.length() == 0)
            return -1;
        
        int[] alpha = new int[26];
        for(char c : s.toCharArray()){
            alpha[c - 'a']++;
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < 26; i++){
            if(alpha[i] == 1)
                min = Math.min(min, s.indexOf(i + 'a'));
        }
        
        if(min == Integer.MAX_VALUE)
            min = -1;
        return min;
    }
}
