import java.util.*;
import java.io.*;
class Main {
	static int n, m;
	static int[][] board, dist;
	static ArrayList<Pair> virus;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int ans = Integer.MAX_VALUE;

	public static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static int bfs(boolean[] isused) {
		Queue<Pair> q = new LinkedList<Pair>();
		dist = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				dist[i][j] = -1;
			}
		}
		for(int i = 0; i < virus.size(); i++) {
			if(isused[i]) {
				int x = virus.get(i).x;
				int y = virus.get(i).y;
				q.add(new Pair(x, y));
				dist[x][y] = 0;
			}
		}
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int tx = p.x; int ty = p.y;
			for(int k = 0; k < 4; k++) {
				int nx = tx + dx[k];
				int ny = ty + dy[k];
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
				if(board[nx][ny] != 1 && dist[nx][ny] == -1) {
					dist[nx][ny] = dist[tx][ty] + 1;
					q.add(new Pair(nx, ny));
				}
			}
		}
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) 
				result = Math.max(result,  dist[i][j]);
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				if(board[i][j] != 1 && dist[i][j] == -1)
					result = -1;
		}
		return result;
	}
	public static void go(int v, int cnt, boolean[] isused) {
		if(cnt == m) {
			int temp = bfs(isused);
			if(temp != -1)
				ans = Math.min(temp, ans);
			return;
		}
		for(int i = v; i < virus.size(); i++) {
			Pair p = virus.get(i);
			if(!isused[virus.indexOf(p)]) {
				isused[virus.indexOf(p)] = true;
				go(v + 1, cnt + 1, isused);
				isused[virus.indexOf(p)] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);

		board = new int[n][n];
		dist = new int[n][n];
		virus = new ArrayList<Pair>();

		for(int i = 0; i < n; i++) {
			String[] line2 = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				int temp = Integer.parseInt(line2[j]);
				board[i][j] = temp;
				if(temp == 2)
					virus.add(new Pair(i, j));
			}
		}

		boolean[] isused = new boolean[virus.size()];
		
		go(0, 0, isused);
		
		if(ans == Integer.MAX_VALUE)
			ans = -1;
		
		System.out.print(ans);
	}
}
