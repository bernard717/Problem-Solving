import java.util.*;
import java.io.*;
class Main {
	static int N, M;
	static char[][] arr;
	static int[] direction = {0, 1, 2, 3};
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	static int ans;
	static Pair red, blue, hole;
	static class Pair{
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static boolean cmp(Pair r, Pair b, int dir) {
		if(dir == 0) return r.y < b.y;
		else if(dir == 1) return r.y > b.y;
		else if(dir == 2) return r.x > b.x;
		else return r.x < b.x;
	}
	public static void recursion(int dir, int depth) {
		char[][] arrbak = new char[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arrbak[i][j] = arr[i][j];
				if(arr[i][j] == 'R') {
					red.x = i; red.y = j;}
				if(arr[i][j] == 'B') {
					blue.x = i; blue.y = j;}
			}
		}
		Pair redbak = new Pair(red.x, red.y);
		Pair bluebak = new Pair(blue.x, blue.y);
		
		if(cmp(red, blue, dir)) {
			boolean redOut = false;
			arr[red.x][red.y] = '.';
			while(arr[red.x + dx[dir]][red.y + dy[dir]] == '.') {
				red.x += dx[dir];
				red.y += dy[dir];
			}
			if(red.x + dx[dir] == hole.x && red.y + dy[dir] == hole.y)
				redOut = true;
			else
				arr[red.x][red.y] = 'R';
			arr[blue.x][blue.y] = '.';
			while(arr[blue.x + dx[dir]][blue.y + dy[dir]] == '.') {
				blue.x += dx[dir];
				blue.y += dy[dir];
			}
			if(blue.x + dx[dir] == hole.x && blue.y + dy[dir] == hole.y) {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++)
						arr[i][j] = arrbak[i][j];
				}
				red.x = redbak.x; red.y = redbak.y;
				blue.x = bluebak.x; blue.y = bluebak.y;
				return;
			}
			if(redOut) {
				ans = Math.min(ans,  depth);
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++)
						arr[i][j] = arrbak[i][j];
				}
				red.x = redbak.x; red.y = redbak.y;
				blue.x = bluebak.x; blue.y = bluebak.y;
				return;
			}
			arr[blue.x][blue.y] = 'B';
		}
		else {
			arr[blue.x][blue.y] = '.';
			while(arr[blue.x + dx[dir]][blue.y + dy[dir]] == '.') {
				blue.x += dx[dir];
				blue.y += dy[dir];
			}
			if(blue.x + dx[dir] == hole.x && blue.y + dy[dir] == hole.y) {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++)
						arr[i][j] = arrbak[i][j];
				}
				red.x = redbak.x; red.y = redbak.y;
				blue.x = bluebak.x; blue.y = bluebak.y;
				return;
			}
			arr[blue.x][blue.y] = 'B';
			arr[red.x][red.y] = '.';
			while(arr[red.x + dx[dir]][red.y + dy[dir]] == '.') {
				red.x += dx[dir];
				red.y += dy[dir];
			}
			if(red.x + dx[dir] == hole.x && red.y + dy[dir] == hole.y) {
				ans = Math.min(ans,  depth);
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++)
						arr[i][j] = arrbak[i][j];
				}
				red.x = redbak.x; red.y = redbak.y;
				blue.x = bluebak.x; blue.y = bluebak.y;
				return;
			}
			arr[red.x][red.y] = 'R';
		}
		if(red.x == redbak.x && red.y == redbak.y && blue.x == bluebak.x && blue.y == bluebak.y) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++)
					arr[i][j] = arrbak[i][j];
			}
			red.x = redbak.x; red.y = redbak.y;
			blue.x = bluebak.x; blue.y = bluebak.y;
			return;
		}
		if(depth == 10) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++)
					arr[i][j] = arrbak[i][j];
			}
			red.x = redbak.x; red.y = redbak.y;
			blue.x = bluebak.x; blue.y = bluebak.y;
			return;
		}
		for(int k = 0; k < 4; k++) {
			recursion(k, depth + 1);
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				arr[i][j] = arrbak[i][j];
		}
		red.x = redbak.x; red.y = redbak.y;
		blue.x = bluebak.x; blue.y = bluebak.y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);

		arr = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String line2 = br.readLine();
			for(int j = 0; j < M; j++) {
				char temp = line2.charAt(j);
				arr[i][j] = temp;
				switch(temp) {
				case 'O': hole = new Pair(i, j); break;
				case 'R': red = new Pair(i, j); break;
				case 'B': blue = new Pair(i, j); break;
				default: break;
				}
			}
		}
		ans = Integer.MAX_VALUE;
		for(int k = 0; k < 4; k++)
			recursion(k, 1);
		if(ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}
}
