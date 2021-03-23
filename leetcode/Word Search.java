class Solution {
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    public boolean ans = false;
    public int row, col;
    
    public boolean exist(char[][] board, String word) {
        char st = word.charAt(0);
        row = board.length;
        col = board[0].length;
        
        boolean[][] visited;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == st){
                    visited = new boolean[row][col];
                    visited[i][j] = true;
                    dfs(board, visited, i, j, word.substring(0, 1), word);
                    System.out.println(i + " " + j);
                }
                if(ans)
                    return ans;
            }
        }
        return ans;
    }
    public void dfs(char[][] board, boolean[][] visited, int i, int j, String now, String word){
        if(ans)
            return;
        if(now.equals(word)){
            ans = true;
            return;
        }
        int idx = now.length();
        for(int k = 0; k < 4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
            if(visited[nx][ny]) continue;
            if(board[nx][ny] != word.charAt(idx)) continue;
            visited[nx][ny] = true;
            dfs(board, visited, nx, ny, now + board[nx][ny], word);
            visited[nx][ny] = false;
        }
    }    
}
