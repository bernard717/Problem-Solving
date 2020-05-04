import java.io.*;
import java.util.*;
class Main {	
	static int N, M, ans;
	static boolean[][] board, visited;
	
	static int[] leftDx = {0, 0, 1, -1};
	static int[] leftDy = {-1, 1, 0, 0};
	
	static int[] backDx = {1, -1, 0, 0};
	static int[] backDy = {0, 0, 1, -1};
	
	static int[] firstDir = {0, 3, 1, 2};
	static int[] dirChange = {2, 3, 1, 0};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        
        board = new boolean[N][M];
        
        line = br.readLine().split(" ");
        int robotX = Integer.parseInt(line[0]);
        int robotY = Integer.parseInt(line[1]);
        int robotDir = firstDir[Integer.parseInt(line[2])];
        
        // true = wall, false = empty space
        for(int i = 0; i < N; i++) {
        	line = br.readLine().split(" ");
        	for(int j = 0; j < M; j++)
        		board[i][j] = Integer.parseInt(line[j]) == 1;
        }
        
        visited = new boolean[N][M];
                
        ans = 0;
        
        dfs(robotX, robotY, robotDir, 1);

        System.out.print(ans);               
    }
    static void dfs(int x, int y, int dir, int oneOrTwo) {
    	if(oneOrTwo == 1) {
    		visited[x][y] = true;
    		ans++;
    	}
    	int cnt = 4;
    	while(cnt-- > 0) {
    		int nx = x + leftDx[dir];
    		int ny = y + leftDy[dir];
    		if(board[nx][ny] || visited[nx][ny]) {
    			dir = dirChange[dir];
    			continue;
    		}
    		dfs(nx, ny, dirChange[dir], 1);
    		break;
    	}
    	if(cnt == -1) {
    		int nx = x + backDx[dir];
    		int ny = y + backDy[dir];
    		if(!board[nx][ny])
    			dfs(nx, ny, dir, 2);
    	}
    }
}
