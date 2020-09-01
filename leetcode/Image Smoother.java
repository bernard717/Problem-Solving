class Solution {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        
        int[][] ans = new int[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                ans[i][j] = calc(M, i, j);
            }
        }
        return ans;
    }
    public int calc(int[][] M, int x, int y){
        int row = M.length;
        int col = M[0].length;
        
        int sum = 0;
        int count = 0;
        
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                int nx = x + i;
                int ny = y + j;
                if(nx < 0 || ny < 0 || nx >= row || ny >= col)
                    continue;
                count++;
                sum += M[nx][ny];
            }
        }
        return sum / count;
    }
}
