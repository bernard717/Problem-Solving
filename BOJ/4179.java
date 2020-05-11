import java.io.*;
import java.util.*;
class Main {	
	private static int N, M;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        char[][] board = new char[N][M];
        
        int jx = 0, jy = 0, fx = 0, fy = 0;
        
        int[][] distJ = new int[N][M];
        int[][] distF = new int[N][M];
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		distJ[i][j] = -1;
        		distF[i][j] = -1;
        	}
        }
        Queue<Pair> fQ = new LinkedList<>();
        Queue<Pair> jQ = new LinkedList<>();
        
        for(int i = 0; i < N; i++) {
        	String line2 = br.readLine();
        	for(int j = 0; j < M; j++) {
        		char temp = line2.charAt(j);
        		if(temp == 'J') {
        			distJ[i][j] = 0;
        			jQ.add(new Pair(i, j));
        		}
        		else if(temp == 'F') {
        			distF[i][j] = 0;
        			fQ.add(new Pair(i, j));
        		}
        		board[i][j] = temp;
        	}
        }
        
        while(!fQ.isEmpty()) {
        	Pair p = fQ.remove();
        	for(int k = 0; k < 4; k++) {
        		int nx = p.x + dx[k];
        		int ny = p.y + dy[k];
        		if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        		if(distF[nx][ny] != -1) continue;
        		if(board[nx][ny] == '#') continue;
        		distF[nx][ny] = distF[p.x][p.y] + 1;
        		fQ.add(new Pair(nx, ny));
        	}
        }
        while(!jQ.isEmpty()) {
        	Pair p = jQ.remove();
        	for(int k = 0; k < 4; k++) {
        		int nx = p.x + dx[k];
        		int ny = p.y + dy[k];
        		if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
        			System.out.print(distJ[p.x][p.y] + 1);
            		return;
        		}
        		if(distJ[nx][ny] != -1) continue;
        		if(board[nx][ny] == '#') continue;
        		if(distF[nx][ny] != -1 && distJ[p.x][p.y] + 1 >= distF[nx][ny]) continue;
        		distJ[nx][ny] = distJ[p.x][p.y] + 1;
        		jQ.add(new Pair(nx, ny));
        	}
        }
        System.out.print("IMPOSSIBLE");
    }
}
