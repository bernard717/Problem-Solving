import java.util.*;
import java.io.*;
class Main {
	static int n;
	static boolean[][] board;
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	static int ans = 0;
	
	public static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void go(Pair start, Pair end, int dir) {
		if(end.x == n - 1 && end.y == n - 1) {
			ans++;
			return;
		}
		Pair p = new Pair(end.x, end.y);
		Pair q;
		if(dir == 0) {
			q = new Pair(end.x, end.y + 1);
			if(q.y < n && board[q.x][q.y]) go(p, q, 0);
			q = new Pair(end.x + 1, end.y + 1);
			if(q.x < n && q.y < n && board[q.x][q.y] && board[q.x - 1][q.y] && board[q.x][q.y - 1]) go(p, q, 2);
		}
		else if(dir == 1) {
			q = new Pair(end.x + 1, end.y);
			if(q.x < n && board[q.x][q.y]) go(p, q, 1);
			q = new Pair(end.x + 1, end.y + 1);
			if(q.x < n && q.y < n && board[q.x][q.y] && board[q.x - 1][q.y] && board[q.x][q.y - 1]) go(p, q, 2);
		}
		else {
			q = new Pair(end.x, end.y + 1);
			if(q.y < n && board[q.x][q.y]) go(p, q, 0);
			q = new Pair(end.x + 1, end.y);
			if(q.x < n && board[q.x][q.y]) go(p, q, 1);
			q = new Pair(end.x + 1, end.y + 1);
			if(q.x < n && q.y < n && board[q.x][q.y] && board[q.x - 1][q.y] && board[q.x][q.y - 1]) go(p, q, 2);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		board = new boolean[n][n];

		for(int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j < n; j++)
				board[i][j] = (Integer.parseInt(line[j]) == 0);
		}
		
		Pair start = new Pair(0, 0);
		Pair end = new Pair(0, 1);
		int dir = 0;
		go(start, end, dir);
		
		System.out.println(ans);
	}
}
