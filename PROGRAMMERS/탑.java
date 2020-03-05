class Solution {
    public int[] solution(int[] heights) {
        int len = heights.length;

        int[] answer = new int[len];

        for(int i = len - 1; i >= 1; i--){
            int temp = heights[i];
            for(int j = i - 1; j >= 0; j--){
                if(heights[j] > temp){
                    answer[i] = j + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
