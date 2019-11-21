import java.util.*;
import java.io.*;
class Main {
	static int R, C, M;
	static class Shark{
		int row, col, speed, dir, size;
		Shark(int row, int col, int speed, int dir, int size){
			this.row = row;
			this.col = col;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}
	static class Pair{
		int row, col, dir;
		Pair(int row, int col, int dir){
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
	}
	static ArrayList<Shark> sharks;
	static int[][] check;
	public static Pair go(int row, int col, int dist, int dir) {
		if(dir == 1) {
			if(dist <= row - 1)
				row -= dist; 
			else
				return go(1, col, (dist - row + 1), 2);
		}
		else if(dir == 2) {
			if(dist <= R - row)
				row += dist;
			else
				return go(R, col, (dist - R + row), 1);
		}
		else if(dir == 3) {
			if(dist <= C - col)
				col += dist;
			else
				return go(row, C, (dist - C + col), 4);
		}
		else if(dir == 4) {
			if(dist <= col - 1)
				col -= dist;
			else
				return go(row, 1, (dist - col + 1), 3);
		}
		Pair p = new Pair(row, col, dir);
		return p;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		M = Integer.parseInt(line[2]);
		sharks = new ArrayList<Shark>();
		check = new int[R + 1][C + 1];
		for(int i = 0; i < M; i++) {
			String[] line2 = br.readLine().split(" ");
			int row = Integer.parseInt(line2[0]);
			int col = Integer.parseInt(line2[1]);
			int speed = Integer.parseInt(line2[2]);
			int dir = Integer.parseInt(line2[3]);
			int size = Integer.parseInt(line2[4]);
			sharks.add(new Shark(row, col, speed, dir, size));
			check[row][col] = size;
		}
		int ans = 0;
		int now = 1;
		// 죽었으면 true, 살았으면 false
		boolean[] live = new boolean[sharks.size()];
		while(now <= C) {
			for(int row = 1; row <= R; row++) {
				if(check[row][now] == 0) continue;
				ans += check[row][now];
				for(Shark s : sharks) {
					if(s.size == check[row][now])
						live[sharks.indexOf(s)] = true;
				}
				check[row][now] = 0;
				break;
			}
			// 이동
			check = new int[R + 1][C + 1];
			for(Shark s : sharks) {
				if(live[sharks.indexOf(s)]) continue;
				Pair p = go(s.row, s.col, s.speed, s.dir);
				if(check[p.row][p.col] == 0)
					check[p.row][p.col] = s.size;
				else {
					if(check[p.row][p.col] > s.size)
						live[sharks.indexOf(s)] = true;
					else {
						for(Shark s1 : sharks) {
							if(s1.size == check[p.row][p.col])
								live[sharks.indexOf(s1)] = true;
						}
						check[p.row][p.col] = s.size;
					}
				}
				s.row = p.row;
				s.col = p.col;
				s.dir = p.dir;
			}
			now++;
		}
		System.out.println(ans);
	}
}
