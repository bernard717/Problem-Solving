import java.util.*;
import java.io.*;
class Main {
	static char[][] board = new char[12][6];
	static boolean[][] check = new boolean[12][6];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Pair> array;
	static int ans = 0;
	static boolean judge = true;

	public static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void setting(int col) {
		ArrayList<Character> temp = new ArrayList<Character>();
		for(int i = 11; i >= 0; i--) {
			if(board[i][col] != '.')
				temp.add(board[i][col]);
		}
		int row = 11;
		for(Character p : temp)
			board[row--][col] = p;
		if(row != 11) {
			for(int i = row; i >= 0; i--)
				board[i][col] = '.';
		}
	}

	public static void dfs(int v, char what, ArrayList<Pair> array) {
		int row = v / 6;
		int col = v % 6;
		for(int k = 0; k < 4; k++) {
			int nx = row + dx[k];
			int ny = col + dy[k];
			if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
			if(board[nx][ny] == '.') continue;
			if(board[nx][ny] == what && !check[nx][ny]) {
				array.add(new Pair(nx, ny));
				check[nx][ny] = true;
				dfs(nx * 6 + ny, what, array);
				//array.remove(new Pair(nx, ny));
				//check[nx][ny] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 12; i++) {
			String line = br.readLine();
			for(int j = 0; j < 6; j++)
				board[i][j] = line.charAt(j);
		}
		while(judge) {
			judge = false;
			for(int i = 0; i < 72; i++) {
				if(board[i / 6][i % 6] == '.') continue;
				check = new boolean[12][6];
				array = new ArrayList<Pair>();
				array.add(new Pair(i / 6, i % 6));
				check[i / 6][i % 6] = true;
				dfs(i, board[i / 6][i % 6], array);
				if(array.size() >= 4) {
					for(int j = 0; j < array.size(); j++) {
						int x = array.get(j).x;
						int y = array.get(j).y;
						board[x][y] = '.';
					}
					judge = true;
				}
			}

			for(int col = 0; col < 6; col++)
				setting(col);
			if(judge)
				ans++;
		}
		System.out.println(ans);
	}
}
