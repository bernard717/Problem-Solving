import java.io.*;
import java.util.*;
class Main {	
	static int N, M, ans;
	static int[][] board;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][][] dirs = {{}, {{0}, {1}, {2}, {3}}, {{0, 1}, {2, 3}}, 
			{{0, 3}, {1, 3}, {0, 2}, {1, 2}}, {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}}, {{0, 1, 2, 3}}};
    static int[] dirNum = {0, 4, 2, 4, 4, 1};
    
    static class Pair{
    	int x, y;
    	public Pair(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        board = new int[N][M];
        for(int i = 0; i < N; i++) {
        	line = br.readLine().split(" ");
        	for(int j = 0; j < M; j++)
        		board[i][j] = Integer.parseInt(line[j]);
        }
        ans = Integer.MAX_VALUE;
        dfs(0);
        System.out.print(ans);
    }
	static void dfs(int now) {
		if(now == N * M) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(board[i][j] == 0)
						sum++;
				}
			}
			ans = Math.min(ans,  sum);
			return;
		}
		int x = now / M;
		int y = now % M;
		int what = board[x][y];
		if(what == 0 || what >= 6)
			dfs(now + 1);
		else {
			int num = dirNum[what];
			HashSet<Pair> changing = new HashSet<>();
			for(int i = 0; i < num; i++) {
				changing = calc(x, y, what, i);
				for(Pair p : changing)
					board[p.x][p.y] = 7;
				dfs(now + 1);
				for(Pair p : changing)
					board[p.x][p.y] = 0;
			}
		}
	}
	static HashSet<Pair> calc(int x, int y, int kind, int dir){
		HashSet<Pair> set = new HashSet<>();
		for(int i = 0; i < dirs[kind][dir].length; i++) {
			int nowDir = dirs[kind][dir][i];
			int nx = x;
			int ny = y;
			while(true) {
				nx = nx + dx[nowDir];
				ny = ny + dy[nowDir];
				if(outOfBound(nx,  ny)) break;
				if(board[nx][ny] == 6) break;
				if(board[nx][ny] == 0) set.add(new Pair(nx, ny));
			}
		}
		return set;
	}
	static boolean outOfBound(int x, int y) {
		return (x < 0 || y < 0 || x >= N || y >= M);
	}
}
