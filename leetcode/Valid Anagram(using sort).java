class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] sToChar = s.toCharArray();
        char[] tToChar = t.toCharArray();
        
        Arrays.sort(sToChar);
        Arrays.sort(tToChar);
    
        return Arrays.equals(sToChar, tToChar);
    }
}
