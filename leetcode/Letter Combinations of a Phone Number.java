class Solution {
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private List<String> res = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        
        int len = digits.length();
        
        if(len == 0)
            return new ArrayList<>();
        
        add(new StringBuilder(), digits, 0);
        
        return res;
    }
    public void add(StringBuilder s, String digits, int nowLen){
        if(nowLen == digits.length()){
            res.add(s.toString());
            return;
        }
        String temp = letters.get(digits.charAt(nowLen));
        for(char letter : temp.toCharArray()){
            s.append(letter);
            add(s, digits, nowLen + 1);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
