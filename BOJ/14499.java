package practice_package;

import java.io.*;
import java.util.*;
class Main {
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        
        int x = Integer.parseInt(line[2]);
        int y = Integer.parseInt(line[3]);
        
        int K = Integer.parseInt(line[4]);
        
        int[][] board = new int[N][M];
        
        for(int i = 0; i < N; i++) {
        	line = br.readLine().split(" ");
        	for(int j = 0; j < M; j++)
        		board[i][j] = Integer.parseInt(line[j]);
        }
        
        int[] dir = new int[K];
        line = br.readLine().split(" ");
        for(int i = 0; i < K; i++)
        	dir[i] = Integer.parseInt(line[i]);
        
        int[][] diceChange = {{0, 0, 0, 0, 0, 0, 0},
        		{0, 3, 2, 6, 1, 5, 4},
        		{0, 4, 2, 1, 6, 5, 3},
        		{0, 2, 6, 3, 4, 1, 5},
        		{0, 5, 1, 3, 4, 6, 2}};
        
        int[] dice = {0, 0, 0, 0, 0, 0, 0};
        
        for(int i = 0; i < K; i++) {
        	int nowDir = dir[i];
        	
        	int nx = x + dx[nowDir];
        	int ny = y + dy[nowDir];
        	
        	if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        	
        	x = nx;
        	y = ny;
        	
        	int[] temp = new int[7];
        	for(int j = 1; j <= 6; j++) 
        		temp[j] = dice[diceChange[nowDir][j]];
        	System.arraycopy(temp, 0, dice, 0, temp.length);
        	
        	if(board[x][y] == 0) 
        		board[x][y] = dice[1];
        	else {
        		dice[1] = board[x][y];
        		board[x][y] = 0;
        	}
        	System.out.println(dice[6]);
        }
    }
}
