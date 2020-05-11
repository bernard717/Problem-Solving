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
        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        int[][] board = new int[N][M];
        
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[N][M];
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++)
        		dist[i][j] = -1;
        }
        // 익어야 하는 토마토 수
        int total = 0;
        
        for(int i = 0; i < N; i++) {
        	line = br.readLine().split(" ");
        	for(int j = 0; j < M; j++) {
        		int temp = Integer.parseInt(line[j]);
        		if(temp == 0)
        			total++;
        		else if(temp == 1) {
        			dist[i][j] = 0;
        			q.add(new Pair(i, j));
        		}
        		board[i][j] = temp;
        	}
        }
        int ans = -1;
        int done = 0;
        while(!q.isEmpty()) {
        	Pair p = q.remove();
        	for(int k = 0; k < 4; k++) {
        		int nx = p.x + dx[k];
        		int ny = p.y + dy[k];
        		if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        		if(dist[nx][ny] != -1) continue;
        		if(board[nx][ny] != 0) continue;
        		q.add(new Pair(nx, ny));
        		dist[nx][ny] = dist[p.x][p.y] + 1;
        		ans = Math.max(dist[nx][ny], ans);
        		done++;
        	}
        }
        if(ans == -1)
        	ans = 0;
        if(done != total)
        	System.out.print(-1);
        else
        	System.out.print(ans);
    }
}
