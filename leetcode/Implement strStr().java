class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        
        for(int i = 0; i + nee.length <= hay.length; i++){
            boolean possi = true;
            for(int j = 0; j < nee.length; j++){
                if(hay[i + j] != nee[j]){
                    possi = false;
                    break;
                }
            }
            if(possi)
                return i;
        }
        return -1;
    }
}
