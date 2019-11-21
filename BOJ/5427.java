import java.util.*;
import java.io.*;
class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-- > 0) {
			String[] line = br.readLine().split(" ");
			int w = Integer.parseInt(line[0]);
			int h = Integer.parseInt(line[1]);
			
			char[][] board = new char[h][w];
			ArrayList<Pair> fires = new ArrayList<Pair>();
			Pair human = new Pair(0, 0);
			
			for(int i = 0; i < h; i++) {
				String line2 = br.readLine();
				for(int j = 0; j < w; j++) {
					char temp = line2.charAt(j);
					board[i][j] = temp;
					if(temp == '*')
						fires.add(new Pair(i, j));
					else if(temp == '@')
						human = new Pair(i, j);
				}
			}
			
			int[][] distFire = new int[h][w];
			int[][] distHuman = new int[h][w];
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					distFire[i][j] = -1;
					distHuman[i][j] = -1;
				}
			}
			
			Queue<Pair> q = new LinkedList<Pair>();
			for(Pair p : fires) {
				q.add(p);
				distFire[p.x][p.y] = 0;
			}
			while(!q.isEmpty()) {
				Pair p = q.remove();
				int x = p.x;
				int y = p.y;
				for(int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
					if(board[nx][ny] == '#' || distFire[nx][ny] != -1) continue;
					distFire[nx][ny] = distFire[x][y] + 1;
					q.add(new Pair(nx, ny));
				}
			}
			
			q = new LinkedList<Pair>();
			distHuman[human.x][human.y] = 0;
			q.add(human);
			while(!q.isEmpty()) {
				Pair p = q.remove();
				int x = p.x;
				int y = p.y;
				for(int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
					if(board[nx][ny] == '#' || distHuman[nx][ny] != -1) continue;
					if(distFire[nx][ny] != -1 && distFire[nx][ny] <= distHuman[x][y] + 1) continue;
					distHuman[nx][ny] = distHuman[x][y] + 1;
					q.add(new Pair(nx, ny));
				}
			}
			int ans = Integer.MAX_VALUE;
			
			for(int col = 0; col < w; col++) {
				if(distHuman[0][col] != -1) ans = Math.min(ans,  distHuman[0][col]);
				if(distHuman[h - 1][col] != -1) ans = Math.min(ans,  distHuman[h - 1][col]);
			}
			for(int row = 0; row < h; row++) {
				if(distHuman[row][0] != -1) ans = Math.min(ans,  distHuman[row][0]);
				if(distHuman[row][w - 1] != -1) ans = Math.min(ans,  distHuman[row][w - 1]);
			}
			if(ans != Integer.MAX_VALUE) ans++;
			if(ans == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
			else System.out.println(ans);
		}
	}
}
