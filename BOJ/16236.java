import java.io.*;
import java.util.*;
class Main {	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static class Shark{
		int x, y, size, eaten;
		public Shark(int x, int y) {
			this.x = x;
			this.y = y;
			this.size = 2;
			this.eaten = 0;
		}
	}
	private static class Fish implements Comparable<Fish>{
		int x, y, dist;
		public Fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		public int compareTo(Fish that) {
			if(this.dist < that.dist)
				return -1;
			else if(this.dist == that.dist) {
				if(this.x < that.x)
					return -1;
				else if(this.x == that.x) {
					if(this.y < that.y)
						return -1;
					else
						return 1;
				}
				else
					return 1;
			}
			else
				return 1;
		}
	}
	private static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        
        Shark s = new Shark(0, 0);
        int fishNum = 0;
        
        for(int i = 0; i < N; i++) {
        	String[] line = br.readLine().split(" ");
        	for(int j = 0; j < N; j++) {
        		int temp = Integer.parseInt(line[j]);
        		board[i][j] = temp;
        		if(temp == 9)
        			s = new Shark(i, j);
        		else if(temp != 0)
        			fishNum++;
        	}
        }
        // 물고기가 없으면 바로 종료
        if(fishNum == 0) {
        	System.out.print(0);
        	return;
        }
        int time = 0;
        PriorityQueue<Fish> toBeEaten = new PriorityQueue<>();
        while(true) {
            // 상어에서 다른 칸까지의 거리 계산을 위한 배열
        	int[][] dist = new int[N][N];
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++)
        			dist[i][j] = -1;
        	}
        	toBeEaten = new PriorityQueue<>();
        	
        	dist[s.x][s.y] = 0;
        	Queue<Pair> q = new LinkedList<>();
        	q.add(new Pair(s.x, s.y));
        	while(!q.isEmpty()) {
        		Pair p = q.remove();
        		for(int k = 0; k < 4; k++) {
        			int nx = p.x + dx[k];
        			int ny = p.y + dy[k];
        			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        			if(dist[nx][ny] != -1) continue;
        			if(board[nx][ny] > s.size) continue;
        			dist[nx][ny] = dist[p.x][p.y] + 1;
        			q.add(new Pair(nx, ny));
                    // 상어보다 작은 물고기는 먹을 수 있으므로 우선순위큐에 집어넣음
        			if(board[nx][ny] != 0 && board[nx][ny] < s.size)
        				toBeEaten.add(new Fish(nx, ny, dist[nx][ny]));
        		}
        	}
            // 먹을 물고기가 없으면 종료
        	if(toBeEaten.size() == 0) {
        		System.out.print(time);
        		return;
        	}
            // 우선순위큐에서 가장 우선순위 높은 물고기를 뺌
        	Fish eating = toBeEaten.remove();
        	time += eating.dist;
        	board[s.x][s.y] = 0;
        	s.x = eating.x;
        	s.y = eating.y;
        	s.eaten++;
        	board[s.x][s.y] = 9;
        	if(s.eaten == s.size) {
        		s.eaten = 0;
        		s.size++;
        	}
        }
	}
}
