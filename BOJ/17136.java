import java.util.*;
import java.io.*;

class Main {
	static int[][] a;
	static int[] left;
	static boolean[][] filled;
	static ArrayList<Pair> pos;
	static int min = Integer.MAX_VALUE;

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int check(int x, int y) {
		int what = a[x][y];
		for (int i = 5; i >= 2; i--) {
			boolean judge = true;
			for (int j = 0; j < i; j++) {
				for (int k = 0; k < i; k++) {
					if (x + j >= 10 || y + k >= 10 || filled[x + j][y + k] || a[x + j][y + k] != what) {
						judge = false;
						break;
					}
				}
				if (!judge)
					break;
			}
			if (judge)
				return i;
		}
		return 1;
	}

	static void go(int n, int now, int sum) {
		if (now > min)
			return;
		if (sum == 0) {
			// System.out.println(now);
			min = Math.min(now, min);
			return;
		}
		if (n >= pos.size())
			return;
		Pair p = pos.get(n);
		int x = p.x;
		int y = p.y;
		if (filled[x][y])
			go(n + 1, now, sum);
		else {
			int len = check(p.x, p.y);
			for (int i = len; i >= 1; i--) {
				if (left[i] > 0) {
					for (int j = 0; j < i; j++) {
						for (int k = 0; k < i; k++)
							filled[x + j][y + k] = true;
					}
					left[i]--;
					go(n + 1, now + 1, sum - i * i);
					left[i]++;
					for (int j = 0; j < i; j++) {
						for (int k = 0; k < i; k++)
							filled[x + j][y + k] = false;
					}
				} else
					continue;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		a = new int[10][10];
		filled = new boolean[10][10];
		left = new int[6];
		for (int i = 1; i <= 5; i++)
			left[i] = 5;
		int sum = 0;
		pos = new ArrayList<Pair>();
		for (int i = 0; i < 10; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < 10; j++) {
				int what = Integer.parseInt(line[j]);
				a[i][j] = what;
				if (what == 1) {
					pos.add(new Pair(i, j));
					sum++;
				}
			}
		}
		go(0, 0, sum);
		min = min == Integer.MAX_VALUE ? -1 : min;
		System.out.println(min);
	}
}
