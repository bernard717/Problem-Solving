class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        int res = 0;
        int idx = 0;
        while(idx < len){
            res = res * 26 + getNum(s.charAt(idx++)); 
        }
        return res;
    }
    public int getNum(char c){
        return c - 'A' + 1;
    }
}
