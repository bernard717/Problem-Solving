class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        
        int sum = brown + red;
        
        int smaller = 0, bigger = 0 , possibleBrown;
        
        for(int i = 1; i * i <= sum; i++){
            if(sum % i == 0){
                smaller = i;
                bigger = sum / i;
                
                possibleBrown = 2 * smaller + 2 * bigger - 4;
                if(possibleBrown == brown)
                    break;
            }
        }
        
        answer[0] = bigger;
        answer[1] = smaller;
        
        return answer;
    }
}
