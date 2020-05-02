import java.io.*;
import java.util.*;
class Main {
	static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        
        int[][] board = new int[N][M];
        
        for(int i = 0; i < N; i++) {
        	line = br.readLine().split(" ");
        	for(int j = 0; j < M; j++)
        		board[i][j] = Integer.parseInt(line[j]);
        }
        
        int[][] blockX = {{0, 0, 0, 0}, {0, 1, 2, 3},
        		{0, 0, 1, 1}, {0, 1, 2, 2}, {0, 1, 1, 1},
        		{0, 0, 1, 2}, {0, 0, 0, 1}, {0, 1, 2, 2},
        		{0, 0, 0, 1}, {0, 0, 1, 2}, {0, 1, 1, 1},
        		{0, 1, 1, 2}, {0, 0, 1, 1}, {0, 1, 1, 2},
        		{0, 0, 1, 1}, {0, 0, 0, 1}, {0, 1, 2, 1},
        		{0, 1, 1, 1}, {0, 1, 1, 2}};
        
        int[][] blockY= {{0, 1, 2, 3}, {0, 0, 0, 0},
        		{0, 1, 0, 1}, {0, 0, 0, 1}, {2, 0, 1, 2},
        		{0, 1, 1, 1}, {0, 1, 2, 0}, {1, 1, 0, 1},
        		{0, 1, 2, 2}, {0, 1, 0, 0}, {0, 0, 1, 2},
        		{0, 0, 1, 1}, {1, 2, 0, 1}, {1, 0, 1, 0}, 
        		{0, 1, 1, 2}, {0, 1, 2, 1}, {0, 0, 0, 1},
        		{1, 0, 1, 2}, {1, 0, 1, 1}};
        
        int ans = -1;
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		for(int k = 0; k < blockX.length; k++) {
        			int x1 = i + blockX[k][0];
        			int y1 = j + blockY[k][0];
        			int x2 = i + blockX[k][1];
        			int y2 = j + blockY[k][1];
        			int x3 = i + blockX[k][2];
        			int y3 = j + blockY[k][2];
        			int x4 = i + blockX[k][3];
        			int y4 = j + blockY[k][3];
        			if(outOfBound(x1, y1) || outOfBound(x2, y2)
        					|| outOfBound(x3, y3) 
        					|| outOfBound(x4, y4)) continue;
        			int sum = 0;
        			sum += board[x1][y1] + board[x2][y2] 
        					+ board[x3][y3] + board[x4][y4];
        			if(sum > ans)
        				ans = sum;
        		}
        	}
        }
        System.out.print(ans);
    }
    static boolean outOfBound(int x, int y) {
    	return (x < 0 || y < 0 || x >= N || y >= M);
    }
}
