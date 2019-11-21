class Solution {
    public int solution(int[][] tri) {
        int answer = 0;
        
        int[][] d = new int[501][501];
        
        d[0][0] = tri[0][0];
        
        int height = tri.length;
        
        for(int row = 1; row < height; row++){
            d[row][0] = d[row - 1][0] + tri[row][0];
            for(int col = 1; col < row; col++)
                d[row][col] = Math.max(d[row - 1][col - 1], d[row - 1][col]) + tri[row][col];
            d[row][row] = d[row - 1][row - 1] + tri[row][row];
        }
        for(int i = 0; i < height; i++){
            answer = Math.max(d[height - 1][i], answer);
        }
        
        
        return answer;
    }
}
