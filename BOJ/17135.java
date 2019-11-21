import java.util.*;
import java.io.*;

class Main {
	static int[][] ground, dist1, dist2, dist3;
	static boolean[][] check1, check2, check3;
	static ArrayList<Pair> enemy;
	static int n, m, d;
	static int max = 0;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static void go(int left, int cnt, int time) {
		if(left <= 0) {
			max = Math.max(max,  cnt);
			return;
		}
		ArrayList<Pair> remove1 = new ArrayList<Pair>();
		int x = -1; int y = -1;
		int now = Integer.MAX_VALUE;
		for(int j = 0; j < m; j++) {
			for(int i = 0; i < n; i++) {
				if(ground[i][j] == 1 && dist1[i][j] > 0 && now > dist1[i][j] && dist1[i][j] - time <= d) {
					now = dist1[i][j];
					x = i;
					y = j;
				}
			}
		}
		if(x != -1) {
			dist1[x][y] = 0;
			for(Pair p: enemy) {
				if(p.x == x && p.y == y) {
					remove1.add(p);
					break;}
			}
		}
		x = -1; y = -1;
		now = Integer.MAX_VALUE;
		for(int j = 0; j < m; j++) {
			for(int i = 0; i < n; i++) {
				if(ground[i][j] == 1 && dist2[i][j] > 0 && now > dist2[i][j] && dist2[i][j] - time <= d) {
					now = dist2[i][j];
					x = i;
					y = j;
				}
			}
		}
		if(x != -1) {
			dist2[x][y] = 0;
			for(Pair p: enemy) {
				if(p.x == x && p.y == y) {
					remove1.add(p);
					break;}
			}
		}
		x = -1; y = -1;
		now = Integer.MAX_VALUE;
		for(int j = 0; j < m; j++) {
			for(int i = 0; i < n; i++) {
				if(ground[i][j] == 1 && dist3[i][j] > 0 && now > dist3[i][j] && dist3[i][j] - time <= d) {
					now = dist3[i][j];
					x = i;
					y = j;
				}
			}
		}
		if(x != -1) {
			dist3[x][y] = 0;
			for(Pair p: enemy) {
				if(p.x == x && p.y == y) {
					remove1.add(p);
					break;}
			}
		}
		time++;
		int temp = enemy.size();
		for(Pair p: remove1) {
			enemy.remove(p);
			dist1[p.x][p.y] = 0;
			dist2[p.x][p.y] = 0;
			dist3[p.x][p.y] = 0;
		}
		cnt += temp - enemy.size();
		ArrayList<Pair> remove = new ArrayList<Pair>();
		for(Pair p:  enemy) {
			if(p.x + time >= n){
				remove.add(p);
			}
		}
		for(Pair p: remove) {
			enemy.remove(p);
			dist1[p.x][p.y] = 0;
			dist2[p.x][p.y] = 0;
			dist3[p.x][p.y] = 0;
		}
		go(enemy.size(), cnt, time);
	}
	static void bfs(int x, int y, int num) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x, y));
		if (num == 1)
			check1[x][y] = true;
		else if (num == 2)
			check2[x][y] = true;
		else if (num == 3)
			check3[x][y] = true;
		while (!q.isEmpty()) {
			Pair p = q.remove();
			x = p.x;
			y = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (num == 1) {
					if (!check1[nx][ny]) {
						dist1[nx][ny] = dist1[x][y] + 1;
						check1[nx][ny] = true;
						q.add(new Pair(nx, ny));
					}
				} else if (num == 2) {
					if (!check2[nx][ny]) {
						dist2[nx][ny] = dist2[x][y] + 1;
						check2[nx][ny] = true;
						q.add(new Pair(nx, ny));
					}
				} else if (num == 3) {
					if (!check3[nx][ny]) {
						dist3[nx][ny] = dist3[x][y] + 1;
						check3[nx][ny] = true;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
	}

	static boolean next(int[] b) {
		int i = b.length - 1;
		while (i > 0 && b[i - 1] >= b[i])
			i--;
		if (i <= 0)
			return false;
		int j = b.length - 1;
		while (b[j] <= b[i - 1])
			j--;
		int temp = b[j];
		b[j] = b[i - 1];
		b[i - 1] = temp;
		j = b.length - 1;
		while (j > i) {
			temp = b[j];
			b[j] = b[i];
			b[i] = temp;
			j--;
			i++;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		d = Integer.parseInt(line[2]);
		ground = new int[n + 1][m];
		enemy = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			String[] line2 = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				int what = Integer.parseInt(line2[j]);
				ground[i][j] = what;
				if(what == 1)
					enemy.add(new Pair(i, j));
			}
		}
		int left = enemy.size(); // 남은 적 수
		ArrayList<Pair> newenemy = new ArrayList<Pair>();
		for(Pair p: enemy){
			newenemy.add(p);
		}
		int cnt = 0; // 죽인 적 수
		int[] brute = new int[m];
		for (int i = 0; i < m - 3; i++)
			brute[i] = 0;
		for (int i = m - 3; i < m; i++)
			brute[i] = 1;
		do {
			if(enemy.size() == 0) {
				for(Pair p: newenemy)
					enemy.add(p);}
			ArrayList<Pair> attacker = new ArrayList<Pair>();
			dist1 = new int[n + 1][m];
			dist2 = new int[n + 1][m];
			dist3 = new int[n + 1][m];
			check1 = new boolean[n + 1][m];
			check2 = new boolean[n + 1][m];
			check3 = new boolean[n + 1][m];
			for (int i = 0; i < m; i++) {
				if (brute[i] == 1) {
					attacker.add(new Pair(n, i));
				}
			}
			int k = 0;
			for (Pair p : attacker) {
				bfs(p.x, p.y, ++k);
			}
			go(left, cnt, 0);
		} while (next(brute));
		System.out.println(max);
	}
}
