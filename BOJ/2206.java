import java.util.*;
import java.io.*;
class Main {
	static int n, m;
	static boolean[][] board;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] dist;
	static int ans = Integer.MAX_VALUE;
	public static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		
		board = new boolean[n][m];
		ArrayList<Pair> walls = new ArrayList<Pair>();
		
		
		for(int i = 0; i < n; i++) {
			String line2 = br.readLine();
			for(int j = 0; j < m; j++) {
				board[i][j] = line2.charAt(j) == '0';
				if(!board[i][j])
					walls.add(new Pair(i, j));
			}
		}
				
		dist = new int[n][m];
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < m; j++)
				dist[i][j] = -1;
		}
		dist[0][0] = 1;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0, 0));
		while(!q.isEmpty()) {
			Pair p = q.remove();
			for(int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if(!board[nx][ny]) continue;
				if(dist[nx][ny] == -1) {dist[nx][ny] = dist[p.x][p.y] + 1;
				q.add(new Pair(nx, ny));}
			}
		}
		
		int[][] distToEnd = new int[n][m];
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < m; j++)
				distToEnd[i][j] = -1;
		}
		distToEnd[n - 1][m - 1] = 1;
		q = new LinkedList<Pair>();
		q.add(new Pair(n - 1, m - 1));
		while(!q.isEmpty()) {
			Pair p = q.remove();
			for(int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if(!board[nx][ny]) continue;
				if(distToEnd[nx][ny] == -1) {distToEnd[nx][ny] = distToEnd[p.x][p.y] + 1;
				q.add(new Pair(nx, ny));}
			}
		}
		if(distToEnd[0][0] != -1) ans = distToEnd[0][0];
		
		for(Pair p : walls) {
			int temp1 = Integer.MAX_VALUE, temp2 = Integer.MAX_VALUE;
			for(int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if(dist[nx][ny] != -1) temp1 = Math.min(dist[nx][ny], temp1);
				if(distToEnd[nx][ny] != -1) temp2 = Math.min(distToEnd[nx][ny], temp2);
			}
			if(temp1 == Integer.MAX_VALUE || temp2 == Integer.MAX_VALUE) continue;
			ans = Math.min(temp1 + temp2 + 1, ans);
		}
		
		
		
		if(ans == Integer.MAX_VALUE) ans = -1;
		
		System.out.println(ans);
		
	}
}
