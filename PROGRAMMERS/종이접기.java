class Solution {
    public int[] solution(int n) {
        int len = (int) Math.pow(2, n) - 1;
        int[] answer = new int[len];
        
        int idx = 0;
        answer[idx++] = 0;
        
        for(int i = 2; i <= n; i++){
            answer[idx++] = 0;
            int temp = idx - 1;
            for(int j = temp - 1; j >= 0; j--)
                answer[idx++] = answer[j] == 1 ? 0 : 1;    
        }
        return answer;
    }
}
