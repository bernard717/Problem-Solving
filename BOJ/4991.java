import java.util.*;
import java.io.*;
class Main {
	static int w, h;
	static char[][] board;
	static int[][] dist;
	static int dirtyNum;
	static Pair start;
	static ArrayList<Pair> dirtySpace;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result = Integer.MAX_VALUE;
	static int[] startToDirty;
	static int[][] dirtyToDirty;
	public static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void calc1() {
		startToDirty = new int[dirtyNum];
		int sum = 0;
		Pair now = new Pair(start.x, start.y);
		int x = now.x;
		int y = now.y;
		dist = new int[w][h];
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++)
				dist[i][j] = -1;
		}
		dist[x][y] = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x, y));
		while(!q.isEmpty()) {
			Pair pp = q.remove();
			for(int k = 0; k < 4; k++) {
				int nx = pp.x + dx[k];
				int ny = pp.y + dy[k];
				if(nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
				if(dist[nx][ny] == -1 && board[nx][ny] != 'x') {
					q.add(new Pair(nx, ny));
					dist[nx][ny] = dist[pp.x][pp.y] + 1;
				}
			}
		}
		for(int i = 0; i < dirtyNum; i++)
			startToDirty[i] = dist[dirtySpace.get(i).x][dirtySpace.get(i).y];
	}
	public static void calc2() {
		dirtyToDirty = new int[dirtyNum][dirtyNum];
		for(int cnt = 0; cnt < dirtyNum; cnt++) {
			Pair now = new Pair(dirtySpace.get(cnt).x, dirtySpace.get(cnt).y);
			int x = now.x;
			int y = now.y;
			dist = new int[w][h];
			for(int i = 0; i < w; i++) {
				for(int j = 0; j < h; j++)
					dist[i][j] = -1;
			}
			dist[x][y] = 0;
			Queue<Pair> q = new LinkedList<Pair>();
			q.add(new Pair(x, y));
			while(!q.isEmpty()) {
				Pair pp = q.remove();
				for(int k = 0; k < 4; k++) {
					int nx = pp.x + dx[k];
					int ny = pp.y + dy[k];
					if(nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
					if(dist[nx][ny] == -1 && board[nx][ny] != 'x') {
						q.add(new Pair(nx, ny));
						dist[nx][ny] = dist[pp.x][pp.y] + 1;
					}
				}
			}
			for(int i = 0; i < dirtyNum; i++) {
				Pair p = dirtySpace.get(i);
				dirtyToDirty[cnt][i] = dist[p.x][p.y];
				dirtyToDirty[i][cnt] = dist[p.x][p.y];
			}
		}
	}
	public static int calc(int[] order) {
		int sum = 0;
		sum += startToDirty[order[0]];
		for(int i = 0; i < dirtyNum - 1; i++) {
			int temp = dirtyToDirty[order[i]][order[i + 1]];
			if (temp == -1) return Integer.MAX_VALUE;
			sum += dirtyToDirty[order[i]][order[i + 1]];
		}
		return sum;
	}
	public static void go(int v, int cnt, int[] order, boolean[] isused, ArrayList<Pair> dirtySpace) {
		if(cnt == dirtyNum) {
			result = Math.min(result,  calc(order));
			return;
		}
		for(int i = 0; i < dirtyNum; i++) {
			if(!isused[i]) {
				order[cnt] = i;
				isused[i] = true;
				go(v + 1, cnt + 1, order, isused, dirtySpace);
				isused[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		h = Integer.parseInt(line[0]);
		w = Integer.parseInt(line[1]);
		while(w != 0 || h != 0) {
			board = new char[w][h];
			dirtySpace = new ArrayList<Pair>();
			for(int i = 0; i < w; i++) {
				String line2 = br.readLine();
				for(int j = 0; j < h; j++) {
					char temp = line2.charAt(j);
					board[i][j] = temp;
					if(temp == 'o') start = new Pair(i, j);
					else if(temp == '*') dirtySpace.add(new Pair(i, j));
				}
			}
			dirtyNum = dirtySpace.size();
			int[] order = new int[dirtyNum];
			boolean[] isused = new boolean[dirtyNum];
			
			calc1();
			calc2();
			go(0, 0, order, isused, dirtySpace);
				
			if(result == Integer.MAX_VALUE) result = -1;
			System.out.println(result);
			result = Integer.MAX_VALUE;
			String[] line3 = br.readLine().split(" ");
			h = Integer.parseInt(line3[0]);
			w = Integer.parseInt(line3[1]);
		}
	}
}
