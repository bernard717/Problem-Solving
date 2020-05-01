import java.io.*;
import java.util.*;
class Main {
	static int N;
	static int[][] board;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        
        int appleNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < appleNum; i++) {
        	String[] line = br.readLine().split(" ");
        	int row = Integer.parseInt(line[0]) - 1;
        	int col = Integer.parseInt(line[1]) - 1;
        	board[row][col] = 1;
        }
        
        int turnNum = Integer.parseInt(br.readLine());
        int[] turning = new int[10001];
        
        for(int i = 0; i < turnNum; i++) {
        	String[] line = br.readLine().split(" ");
        	int time = Integer.parseInt(line[0]);
        	char c = line[1].charAt(0);
        	turning[time] = c == 'L' ? 1 : 2;
        }
        
        int time = 0;
        
        // 시작지점
        board[0][0] = 2;
        int dir = 3;
        Deque<Pair> snake = new LinkedList<>();
        snake.add(new Pair(0, 0));
        
        int[][] turnDir = {{2, 3}, {3, 2}, {1, 0}, {0, 1}};
        
        while(true) {
        	// 방향 바꾸는 시간인 경우
        	if(turning[time] != 0) 
        		dir = turnDir[dir][turning[time] - 1];
        	
        	Pair head = snake.peekFirst();
        	
        	int nx = head.x + dx[dir];
        	int ny = head.y + dy[dir];
        	
        	if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
        	if(board[nx][ny] == 2) break;
        	
        	if(board[nx][ny] == 1) {
        		board[nx][ny] = 2;
        		snake.addFirst(new Pair(nx, ny));
        	}
        	else {
        		board[nx][ny] = 2;
        		snake.addFirst(new Pair(nx, ny));
        		Pair tail = snake.removeLast();
        		board[tail.x][tail.y] = 0;
        	}
        
        	time++;
        }
        
        System.out.print(time + 1);
    }
}
