class Solution {
    public String countAndSay(int n) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "11");
        map.put(3, "21");
        map.put(4, "1211");
        map.put(5, "111221");
        
        String ans;
        if(n >= 5){
            ans = map.get(5);
            for(int j = 0; j < n - 5; j++){
                ans = recur(ans);
            }
        }
        else
            ans = map.get(n);
        return ans;
    }
    public String recur(String s){
        int same = 1;
        char now = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == now){
                same++;
            }
            else{
                sb.append(same).append(now);
                now = s.charAt(i);
                same = 1;
            }
        }
        sb.append(same).append(now);
        return sb.toString();
    }
}
