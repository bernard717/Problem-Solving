import java.util.*;
import java.io.*;

class Main {
	static int n;
	static int[][] map, colors;
	static boolean[] visited = new boolean[100];
	static int[] ans = new int[2];
	static int[] dx = {-1, -1, 1, 1};
	static int[] dy = {-1, 1, -1, 1};
	
	public static void dfs(int v, int cnt, int color) {
		ans[color] = Math.max(ans[color], cnt);
		for(int i = v + 1; i < n * n; i++) {
			int col = i % n;
			int row = i / n;
			if(colors[row][col] != color) continue;
			if(map[row][col] == 1) {
				if(check(row, col)) {
					visited[i] = true;
					dfs(i, cnt + 1, color);
					visited[i] = false;
				}
			}
		}
		if(v == n * n - 1) return;
	}
	
	public static boolean check(int x, int y) {
		for(int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			while(nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if(visited[nx * n + ny]) 
					return false;
				nx += dx[k];
				ny += dy[k];
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		colors = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				if((i + j) % 2 == 0)
					colors[i][j] = 1;
				else
					colors[i][j] = 0;
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		dfs(-1, 0, 1);
		dfs(-1, 0, 0);
		
		
		System.out.println(ans[0] + ans[1]);
	}
}
