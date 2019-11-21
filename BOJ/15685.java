import java.util.*;
import java.io.*;
class Main {
	static int n;
	static boolean[][] board = new boolean[110][110];
	static Dragon[] dragons;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static class Dragon{
		Pair p;
		int dir;
		int gen;
		Dragon(Pair p, int dir, int gen){
			this.p = p;
			this.dir = dir;
			this.gen = gen;
		}
	}
	public static class Line{
		int dir;
		Pair start;
		Pair end;
		Line(int dir, Pair start, Pair end){
			this.dir = dir;
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dragons = new Dragon[n];
		
		for(int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			int dir = Integer.parseInt(line[2]);
			int gen = Integer.parseInt(line[3]);
			dragons[i] = new Dragon(new Pair(x, y), dir, gen);
		}
		
		for(Dragon d : dragons) {
			ArrayList<Line> lines = new ArrayList<Line>();
			int gen = d.gen;
			int dir = d.dir;
			Pair p1 = new Pair(d.p.x, d.p.y);
			Pair p2 = new Pair(d.p.x + dx[dir], d.p.y + dy[dir]);
			lines.add(new Line(dir, p1, p2));
			for(int i = 1; i <= gen; i++) {
				int size = lines.size();
				for(int j = 1; size - j >= 0; j++) {
					Line l = lines.get(size - j);
					Line l2 = lines.get(lines.size() - 1);
					dir = l.dir + 1 > 3 ? 0 : l.dir + 1;
					Pair p3 = l2.end;
					Pair p4 = new Pair(l2.end.x + dx[dir], l2.end.y + dy[dir]);
					lines.add(new Line(dir, p3, p4));
				}
			}
			for(Line l : lines) {
				board[l.start.y][l.start.x] = true;
				board[l.end.y][l.end.x] = true;
			}
		}
		int sum = 0;
		for(int i = 0; i <= 105; i++) {
			for(int j = 0; j <= 105; j++) {
				if(board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1])
					sum++;
			}
		}
		System.out.println(sum);
	}
}
