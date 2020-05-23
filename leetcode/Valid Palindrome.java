class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0)
            return true;
        
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char front = s.charAt(i);
            char back = s.charAt(j);
            if(!Character.isLetterOrDigit(front))
                i++;
            else if(!Character.isLetterOrDigit(back))
                j--;
            else {
                if(Character.toLowerCase(front) != Character.toLowerCase(back))
                    return false;
                i++;
                j--;
            }
        }
        return true;
    }
}
