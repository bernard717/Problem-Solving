import java.util.*;
import java.io.*;
class Main {
	static int n, m, h;
	static boolean[][] check;
	static int ans = -1;
	static class Pair {
		int a, b;
		Pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	public static boolean go(){
		for(int i = 1; i <= n; i++) {
			int row = 1; 
			int col = i;
			while(row <= h) {
				if(check[row][col]) { 
					col++; 
					row++;
				}
				else if(check[row][col - 1]) {
					col--; 
					row++;
				}
				else
					row++;
			}
			if(col != i) return false;
		}
		return true;
	}
	public static void recur(Pair recent, int currentDepth, int maxDepth) {
		if(ans != -1 && ans <= currentDepth) return;
		if(go()) {
			ans = currentDepth;
			return;
		}
		if(currentDepth == maxDepth) return;
		for(int i = recent.a; i < h + 1; i++) {
			for(int j = 1; j < n; j++) {
				if(i == recent.a && j <= recent.b) continue;
				if(check[i][j - 1] || check[i][j] || check[i][j + 1]) continue;
				check[i][j] = true;
				recur(new Pair(i, j), currentDepth + 1, maxDepth);
				check[i][j] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		h = Integer.parseInt(line[2]);
		check = new boolean[35][15];
		
		if(m == 0) {
			System.out.println(0);
			return;
		}
		
		for(int i = 0; i < m; i++) {
			String[] line2 = br.readLine().split(" ");
			int a = Integer.parseInt(line2[0]);
			int b = Integer.parseInt(line2[1]);
			check[a][b] = true;
		}
		
		if(go()) {
			System.out.println(0);
			return;
		}
		recur(new Pair(1, 1), 0, 3);
		
		System.out.println(ans);
	}
}
