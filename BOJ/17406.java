import java.util.*;
import java.io.*;
class Main {
	static int n, m, k;
	static int[][] board;
	static int ans = Integer.MAX_VALUE;
	public static int calc() {
		int temp = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum = 0;
			for(int j = 0; j < m; j++)
				sum += board[i][j];
			temp = Math.min(sum, temp);
		}
		return temp;
	}
	
	public static class Pair{
		int r, c, s;
		Pair(int r, int c, int s){
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	public static boolean next(int[] order) {
		int i = order.length - 1;
		while(i > 0 && order[i - 1] >= order[i])
			i--;
		if(i <= 0) return false;
		int j = order.length - 1;
		while(order[j] <= order[i - 1])
			j--;
		int temp = order[i - 1];
		order[i - 1] = order[j];
		order[j] = temp;
		
		j = order.length - 1;
		while(i < j) {
			temp = order[i];
			order[i] = order[j];
			order[j] = temp;
			i++;
			j--;
		}
		return true;
	}
	
	public static void go(int r, int c, int s, int[][] board3) {
		if(s == 0) {
			return;
		}		
		for(int i = c - s; i < c + s; i++)
			board3[r - s][i + 1] = board[r - s][i];
		for(int i = r - s; i < r + s; i++)
			board3[i + 1][c + s] = board[i][c + s];
		for(int i = c + s; i > c - s; i--)
			board3[r + s][i - 1] = board[r + s][i];
		for(int i = r + s; i > r - s; i--)
			board3[i - 1][c - s] = board[i][c - s];
		
		for(int i = c - s; i < c + s; i++)
			board[r - s][i] = board3[r - s][i];
		for(int i = r - s; i < r + s; i++)
			board[i][c + s] = board3[i][c + s];
		for(int i = c + s; i > c - s; i--)
			board[r + s][i] = board3[r + s][i];
		for(int i = r + s; i > r - s; i--)
			board[i][c - s] = board3[i][c - s];
		
		go(r, c, s - 1, board3);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		k = Integer.parseInt(line[2]);
		
		board = new int[n][m];
		int[][] board2 = new int[n][m];

		for(int i = 0; i < n; i++) {
			String[] line2 = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(line2[j]);
				board2[i][j] = Integer.parseInt(line2[j]);
			}
		}
		
		int[] order = new int[k];
		Pair[] pairs = new Pair[k];
		for(int i = 0; i < k; i++) {
			String[] line3 = br.readLine().split(" ");
			int r = Integer.parseInt(line3[0]) - 1;
			int c = Integer.parseInt(line3[1]) - 1;
			int s = Integer.parseInt(line3[2]);
			pairs[i] = new Pair(r, c, s);
		}
		
		for(int i = 0; i < k; i++)
			order[i] = i;
		
		do {
			// board 원상 복구
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++)
					board[i][j] = board2[i][j];
			}
			// order에 따라 연산 진행
			for(int i = 0; i < k; i++) {
				Pair p = pairs[order[i]];
				int[][] board3 = new int[n][m];
				go(p.r, p.c, p.s, board3);
			}
			ans = Math.min(ans,  calc());
		}while(next(order));
		
		
		
		System.out.println(ans);
	}
}
