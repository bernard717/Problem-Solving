class Solution {
    public List<String> ans = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        go("", 0, 0, n);
        
        return ans;
    }
    
    public void go(String s, int l, int r, int n){
        if(l == n && r == n){
            ans.add(s);
            return;
        }
        if(l >= r + 1)
            go(s + ")", l, r + 1, n);
        if(l < n)
            go(s + "(", l + 1, r, n);
    }
}
