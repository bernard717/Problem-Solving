class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0)
            return;
        int row = board.length;
        int col = board[0].length;
        
        boolean[][] toBeChanged = new boolean[row][col];
        boolean[][] visited;
        
        for(int i = 1; i < row - 1; i++){
            for(int j = 1; j < col - 1; j++){
                visited = new boolean[row][col];
                if(board[i][j] == 'X') continue;
                if(toBeChanged[i][j]) continue;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, j));
                visited[i][j] = true;
                boolean addOrNot = true;
                List<Pair> temp = new ArrayList<>();
                temp.add(new Pair(i, j));
                while(!q.isEmpty()){
                    Pair p = q.remove();
                    for(int k = 0; k < 4; k++){
                        int nx = p.x + dx[k];
                        int ny = p.y + dy[k];
                        if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                        if(board[nx][ny] == 'X' || visited[nx][ny]) continue;
                        if(isBorder(nx, ny, row, col)){
                            addOrNot = false;
                            break;
                        }
                        q.add(new Pair(nx, ny));
                        temp.add(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    }
                    if(!addOrNot){
                        break;
                    }
                }
                if(addOrNot){
                    for(Pair p : temp){
                        toBeChanged[p.x][p.y] = true;
                    }
                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(toBeChanged[i][j])
                    board[i][j] = 'X';
            }
        }
    }
    public boolean isBorder(int x, int y, int row, int col){
        return x == 0 || x == row - 1 || y == 0 || y == col - 1;
    }
}
