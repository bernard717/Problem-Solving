import java.util.*;
import java.io.*;
class Main {
	static int n;
	static int[][] score;
	static int ans = -1;
	
	public static int calc(int[] player) {
		int sum = 0;
		int inning = 1;
		int out = 0;
		int start = 0;
		boolean[] runner = new boolean[3];
		while(inning <= n) {
			boolean[] runnerTemp = new boolean[3];
			int temp = score[inning - 1][player[start] - 1];
			if(temp == 0) {
				out++;
				if(out == 3) {
					inning++;
					for(int i = 0; i <= 2; i++) runner[i] = runnerTemp[i];
					out = 0;
				}
			}
			else if(temp == 1) {
				runnerTemp[0] = true;
				if(runner[0]) runnerTemp[1] = true;
				if(runner[1]) runnerTemp[2] = true;
				if(runner[2]) sum++;
				for(int i = 0; i <= 2; i++) runner[i] = runnerTemp[i];
			}
			else if(temp == 2) {
				runnerTemp[1] = true;
				if(runner[0]) runnerTemp[2] = true;
				if(runner[1]) sum++; 
				if(runner[2]) sum++;
				for(int i = 0; i <= 2; i++) runner[i] = runnerTemp[i];
			}
			else if(temp == 3) {
				runnerTemp[2] = true;
				if(runner[0]) sum++;
				if(runner[1]) sum++;
				if(runner[2]) sum++;
				for(int i = 0; i <= 2; i++) runner[i] = runnerTemp[i];
			}
			else  {
				sum++;
				if(runner[0]) sum++;
				if(runner[1]) sum++;
				if(runner[2]) sum++;
				for(int i = 0; i <= 2; i++) runner[i] = runnerTemp[i];
			}
			start = start + 1 > 8 ? 0 : start + 1;
		}
		return sum;
	}
	
	public static void go(int[] player, boolean[] isused, int cnt) {
		if(cnt == 9) {
			ans = Math.max(ans, calc(player));
			return;
		}
		for(int i = 1; i < 9; i++) {
			if(!isused[i]) {
				if(cnt == 3) cnt++;
				player[cnt] = i + 1;
				isused[i] = true;
				go(player, isused, cnt + 1);
				player[cnt] = 0;
				isused[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		score = new int[n][9];
		
		for(int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j < 9; j++)
				score[i][j] = Integer.parseInt(line[j]);
		}
		
		int[] player = new int[9];
		boolean[] isused = new boolean[9];
		player[3] = 1;
		isused[0] = true;
		
		go(player, isused, 0);
		
		System.out.println(ans);
	}
}
