import java.util.*;
import java.io.*;
class Main {
	static int N, M, K, startX, startY;
	static int[][] arr;
	static int[] idx, dice;
	
	public static void move(int dir) {
		if(dir == 1) {
			int temp1 = idx[4];
			int temp3 = idx[1];
			int temp4 = idx[6];
			int temp6 = idx[3];
			idx[1] = temp1;
			idx[3] = temp3;
			idx[4] = temp4;
			idx[6] = temp6;
		}
		else if(dir == 2) {
			int temp1 = idx[3];
			int temp3 = idx[6];
			int temp4 = idx[1];
			int temp6 = idx[4];
			idx[1] = temp1;
			idx[3] = temp3;
			idx[4] = temp4;
			idx[6] = temp6;
		}
		else if(dir == 3) {
			int temp1 = idx[5];
			int temp2 = idx[1];
			int temp5 = idx[6];
			int temp6 = idx[2];
			idx[1] = temp1;
			idx[2] = temp2;
			idx[5] = temp5;
			idx[6] = temp6;
		}
		else if(dir == 4) {
			int temp1 = idx[2];
			int temp2 = idx[6];
			int temp5 = idx[1];
			int temp6 = idx[5];
			idx[1] = temp1;
			idx[2] = temp2;
			idx[5] = temp5;
			idx[6] = temp6;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		startX = Integer.parseInt(line[2]);
		startY = Integer.parseInt(line[3]);
		K = Integer.parseInt(line[4]);
		
		arr = new int[N][M];
		idx = new int[7];
		dice = new int[7];
		
		for(int i = 0; i < N; i++) {
			String[] line2 = br.readLine().split(" ");
			for(int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(line2[j]);
		}
		for(int i = 1; i <= 6; i++)
			idx[i] = i;
		
		String[] line3 = br.readLine().split(" ");
		
		for(int i = 0; i < K; i++) {
			int dir = Integer.parseInt(line3[i]);
			if(dir == 1 && startY < M - 1)
				startY++;
			else if(dir == 2 && startY > 0)
				startY--;
			else if(dir == 3 && startX > 0)
				startX--;
			else if(dir == 4 && startX < N - 1)
				startX++;
			else continue;
			move(dir);
			if(arr[startX][startY] == 0) 
				arr[startX][startY] = dice[idx[6]];
			else {
				dice[idx[6]] = arr[startX][startY];
				arr[startX][startY] = 0;
			}
			System.out.println(dice[idx[1]]);
		}
	}
}
