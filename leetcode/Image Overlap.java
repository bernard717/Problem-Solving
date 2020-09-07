class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int ans = 0;
        int n = A[0].length;
        
        int[][] board = new int[3 * n][3 * n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[n - 1 + i][n - 1 + j] = A[i][j];
            }
        }
        
        for(int row = 0; row < 2 * n - 1; row++){
            for(int col = 0; col < 2 * n - 1; col++){
                int tmp = 0;
                for(int x = 0; x < n; x++){
                    for(int y = 0; y < n; y++){
                        tmp += board[row + x][col + y] * B[x][y]; 
                    }
                }
                ans = Math.max(tmp, ans);
            }
        }
        return ans;
    }
}
