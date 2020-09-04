class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] end = new int[26];
        for(int i = 0; i < 26; i++)
            end[i] = -1;
        
        char[] chars = S.toCharArray();
        int len = chars.length;
        for(int i = 0; i < len; i++){
            end[chars[i] - 'a'] = i;   // 각 알파벳의 끝 인덱스를 저장
        }
        List<Integer> ans = new ArrayList<>();
        
        int max = end[chars[0] - 'a'];
        int last = 0;
        for(int st = 0; st < len; st++){
            char now = chars[st];
            // 현재 인덱스가 max값보다 큰 경우
            if(st > max){
                ans.add(st - last);
                last = st;
                max = end[chars[st] - 'a'];
            }
            else{
                int localMax = end[now - 'a'];
                if(localMax > max)
                    max = localMax;
            }           
        }
        ans.add(len - last);
        
        return ans;
    }
}
