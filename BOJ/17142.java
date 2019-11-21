import java.util.*;
import java.io.*;
class Main {
	static int N, M, P;
	static int[][] arr, dist;
	static int[] d;
	static ArrayList<Pair> virus;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void swap(int x, int y) {
		int temp = d[x];
		d[x] = d[y];
		d[y] = temp;
	}
	
	public static boolean next() {
		int i = P - 1;
		while(i > 0 && d[i] <= d[i - 1])
			i--;
		if(i <= 0)
			return false;
		int j = P - 1;
		while(d[j] <= d[i - 1])
			j--;
		swap(j, i - 1);
		j = P - 1;
		while(i < j) {
			swap(i, j);
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		
		arr = new int[N][N];
		P = 0;
		virus = new ArrayList<Pair>();
		int empty = 0;
		for(int i = 0; i < N; i++) {
			String[] line2 = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(line2[j]);
				if(temp == 2) {
					P++;
					virus.add(new Pair(i, j));
				}
				if(temp == 0)
					empty++;
				arr[i][j] = temp;
			}
		}
		
		d = new int[P];
		for(int i = P - M; i < P; i++)
			d[i] = 1;
		int min = Integer.MAX_VALUE;
		do {
			int left = empty;
			dist = new int[N][N];
			Queue<Pair> q = new LinkedList<Pair>();
			for(int i = 0; i < P; i++) {
				int x = virus.get(i).x;
				int y = virus.get(i).y;
				if(d[i] == 1) 
					q.add(new Pair(x, y));
				else
					dist[x][y] = -1;
			}
			while(!q.isEmpty()) {
				Pair p = q.remove();
				int x = p.x;
				int y = p.y;
				for(int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					if(arr[nx][ny] == 1) continue;
					if(arr[nx][ny] == 2 && dist[nx][ny] == -1){
						dist[nx][ny] = dist[x][y] + 1;
						q.add(new Pair(nx, ny));
					}
					if(arr[nx][ny] == 0 && dist[nx][ny] == 0) {
						left--;
						dist[nx][ny] = dist[x][y] + 1;
						q.add(new Pair(nx, ny));
					}
				}
			}
			int ans = 0;
			if(left != 0) continue;
			for(int i = 0; i < N; i++){
	            for(int j = 0; j < N; j++) {
	            	if(arr[i][j] == 1 || arr[i][j] == 2) continue;
	                ans = Math.max(dist[i][j], ans);
	            }
	        }
			min = Math.min(ans,  min);
		}while(next());
		if(min == Integer.MAX_VALUE)
			min = -1;
		if(empty == 0)
			min = 0;
		System.out.println(min);
	}
}
