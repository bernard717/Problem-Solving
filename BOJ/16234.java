import java.io.*;
import java.util.*;
class Main {	
	private static int N, L, R;
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
        L = Integer.parseInt(line[1]);
        R = Integer.parseInt(line[2]);
        
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
        	line = br.readLine().split(" ");
        	for(int j = 0; j < N; j++)
        		board[i][j] = Integer.parseInt(line[j]);
        }
        
        boolean[][] visited;
        int moveNum;
        Queue<Pair> q;
        ArrayList<Pair> arr;
        int sum;
        int ans = -1;
        
        do {
        	ans++;
        	visited = new boolean[N][N];
        	int[][] temp = new int[N][N];
        	moveNum = 0;
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++) {
        			if(visited[i][j]) continue;
        			visited[i][j] = true;
                	sum = board[i][j];
                	q = new LinkedList<>();
                	arr = new ArrayList<>();
                	q.add(new Pair(i, j));
                	arr.add(new Pair(i, j));
                	while(!q.isEmpty()) {
                		Pair p = q.remove();
                		for(int k = 0; k < 4; k++) {
                			int nx = p.x + dx[k];
                			int ny = p.y + dy[k];
                			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                			if(visited[nx][ny]) continue;
                			int diff = Math.abs(board[p.x][p.y] - board[nx][ny]);
                			if(diff >= L && diff <= R) {
                				q.add(new Pair(nx, ny));
                				arr.add(new Pair(nx, ny));
                				sum += board[nx][ny];
                    			visited[nx][ny] = true;
                			}
                		}
                	}
                	if(arr.size() <= 1) continue;
                	moveNum++;
                	int num = arr.size();
                	for(Pair p : arr) 
                		temp[p.x][p.y] = sum / num;
        		}
        	}
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++) {
        			if(temp[i][j] != 0)
        				board[i][j] = temp[i][j];
        		}
        	}
        }while(moveNum > 0);
        System.out.print(ans);
    }
}
