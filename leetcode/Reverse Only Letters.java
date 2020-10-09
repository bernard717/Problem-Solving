class Solution {
    public String reverseOnlyLetters(String s) {
        int len = s.length();
        int p1 = 0;
        int p2 = len - 1;
        
        StringBuilder sb = new StringBuilder();
        
        for(p1 = 0; p1 < len; p1++){
            if(isLetter(s.charAt(p1))){
               while(!isLetter(s.charAt(p2)))
                   p2--;
                sb.append(s.charAt(p2--));
            }
            else{
                sb.append(s.charAt(p1));
            }
        }
    
        return sb.toString();
    }
    public boolean isLetter(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
