import java.util.*;
import java.io.*;

class Main{
	static int n, answer = 0;
	static int[][] a;
	static int check(int[][] a) {
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				ans = Math.max(ans, a[i][j]);
		}
		return ans;
	}
	static void go(int cnt, int[][] a) {
		if(cnt == 5) {
			answer = Math.max(answer, check(a));
			return;
		}
		int[][] map = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				map[i][j] = a[i][j];
		}
		up();
		go(cnt + 1, a);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				a[i][j] = map[i][j];
		}
		down();
		go(cnt + 1, a);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				a[i][j] = map[i][j];
		}
		left();
		go(cnt + 1, a);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				a[i][j] = map[i][j];
		}
		right();
		go(cnt + 1, a);
	}
	public static void up() {
		for(int i = 0; i < n; i++) {
			int now = 0;
			int what = 0;
			int where = 0;
			for(int j = 0; j < n; j++) {
				if(a[j][i] == 0) continue;
				now++;
				if(now == 1) {
					a[where][i] = a[j][i];
					what = a[j][i];
					if(where != j)
						a[j][i] = 0;
				}
				else if(now == 2) {
					if(a[j][i] != what) {
						a[++where][i] = a[j][i];
						what = a[j][i];
						if(where != j)
							a[j][i] = 0;
						now = 1;
					} 
					else {
						a[where][i] *= 2;
						a[j][i] = 0;
						where++;
						now = 0;
					}
				}
			}
		}
	}
	public static void down() {
		for(int i = 0; i < n; i++) {
			int now = 0;
			int what = 0;
			int where = n - 1;
			for(int j = n - 1; j >= 0; j--) {
				if(a[j][i] == 0) continue;
				now++;
				if(now == 1) {
					a[where][i] = a[j][i];
					what = a[j][i];
					if(where != j)
						a[j][i] = 0;
				}
				else if(now == 2) {
					if(a[j][i] != what) {
						a[--where][i] = a[j][i];
						what = a[j][i];
						if(where != j)
							a[j][i] = 0;
						now = 1;
					} 
					else {
						a[where][i] *= 2;
						a[j][i] = 0;
						where--;
						now = 0;
					}
				}
			}
		}
	}
	public static void left() {
		for(int i = 0; i < n; i++) {
			int now = 0;
			int what = 0;
			int where = 0;
			for(int j = 0; j < n; j++) {
				if(a[i][j] == 0) continue;
				now++;
				if(now == 1) {
					a[i][where] = a[i][j];
					what = a[i][j];
					if(where != j)
						a[i][j] = 0;
				}
				else if(now == 2) {
					if(a[i][j] != what) {
						a[i][++where] = a[i][j];
						what = a[i][j];
						if(where != j)
							a[i][j] = 0;
						now = 1;
					} 
					else {
						a[i][where] *= 2;
						a[i][j] = 0;
						where++;
						now = 0;
					}
				}
			}
		}
	}
	public static void right() {
		for(int i = 0; i < n; i++) {
			int now = 0;
			int what = 0;
			int where = n - 1;
			for(int j = n - 1; j >= 0; j--) {
				if(a[i][j] == 0) continue;
				now++;
				if(now == 1) {
					a[i][where] = a[i][j];
					what = a[i][j];
					if(where != j)
						a[i][j] = 0;
				}
				else if(now == 2) {
					if(a[i][j] != what) {
						a[i][--where] = a[i][j];
						what = a[i][j];
						if(where != j)
							a[i][j] = 0;
						now = 1;
					} 
					else {
						a[i][where] *= 2;
						a[i][j] = 0;
						where--;
						now = 0;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        for(int i = 0; i < n; i++) {
        	String[] line = br.readLine().split(" ");
        	for(int j = 0; j < n; j++)
        		a[i][j] = Integer.parseInt(line[j]);
        }
        go(0, a);
        System.out.print(answer);
        
        
    }
}
