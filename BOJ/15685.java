import java.io.*;
import java.util.*;
class Main {	
	static int[][] board = new int[105][105];
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[] dirChange = {3, 0, 2, 1};
	static int[] rotate = {2, 3, 1, 0};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	String[] line = br.readLine().split(" ");
        	int stX = Integer.parseInt(line[0]);
        	int stY = Integer.parseInt(line[1]);
        	int dir = dirChange[Integer.parseInt(line[2])];
        	int gen = Integer.parseInt(line[3]);
        	
        	board[stX][stY] = 1;
        	ArrayList<Integer> dirs = new ArrayList<>();
        	dirs.add(dir);
        	dfs(stX, stY, -1, gen, dirs);
        }
        int sum = 0;
        for(int x = 0; x <= 100; x++) {
        	for(int y = 0; y <= 100; y++) {
        		if(board[x][y] == 0) continue;
        		if(board[x + 1][y] == 0) continue;
        		if(board[x][y + 1] == 0) continue;
        		if(board[x + 1][y + 1] == 0) continue;
        		sum++;
        	}
        }
        System.out.print(sum);
    }
	static void dfs(int x, int y, int nowGen, int goalGen, ArrayList<Integer> dirs) {
		if(nowGen == goalGen) {
			return;
		}
		ArrayList<Integer> adding = new ArrayList<>();
		int idx = nowGen == -1 ? 0 : (int)Math.pow(2,  nowGen);
		for(int i = idx; i < dirs.size(); i++) {
			x += dx[dirs.get(i)];
			y += dy[dirs.get(i)];
			board[x][y] = 1;
		}
		for(int dir : dirs) {
			adding.add(rotate[dir]);
		}
		for(int i = adding.size() - 1; i >= 0; i--)
			dirs.add(adding.get(i));
		dfs(x, y, nowGen + 1, goalGen, dirs);
	}
}
