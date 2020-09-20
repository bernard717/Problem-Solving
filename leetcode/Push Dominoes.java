class Solution {
    public String pushDominoes(String dominoes) {
        if(dominoes.length() <= 1)
            return dominoes;
        String next = getNext(dominoes);
        
        while(!dominoes.equals(next)){
            dominoes = next;
            next = getNext(dominoes);
        }
        
        return dominoes;
    }
    
    
    public String getNow(String s, int k){
        if(k == 0){
            if(s.charAt(k + 1) == 'L')
                return "L";
            return ".";
        }
        if(k == s.length() - 1){
            if(s.charAt(k - 1) == 'R')
                return "R";
            return ".";
        }
        char left = s.charAt(k - 1);
        char right = s.charAt(k + 1);
        if(left == 'R' && right == 'L')
            return ".";
        if(left == 'R')
            return "R";
        if(right == 'L')
            return "L";
        return ".";
    }
    
    public String getNext(String s){
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        
        
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '.')
                sb.append(getNow(s, i));
            else
                sb.append(s.substring(i, i + 1));
        }
        
        return sb.toString();
    }
}
