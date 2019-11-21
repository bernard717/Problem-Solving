import java.util.*;
import java.io.*;
class Main {
	static int R, C, T;
	static int[][] arr;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		T = Integer.parseInt(line[2]);
		arr = new int[R][C];
		int up = -1;
		int down = -1;

		for(int i = 0; i < R; i++) {
			String[] line2 = br.readLine().split(" ");
			for(int j = 0; j < C; j++) {
				int temp = Integer.parseInt(line2[j]);
				arr[i][j] = temp;
				if(temp == -1 && up == -1)
					up = i;
			}
		}
		down = up + 1;
		int time = 0;
		while(time++ < T) {
			int[][] tempArr = new int[R][C];
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(arr[i][j] == 0 || arr[i][j] == -1) continue;
					int num = 0;
					int what = arr[i][j] / 5;
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(nx < 0 || ny < 0 || nx >= R || ny >= C || (nx == up && ny == 0) || (nx == down && ny == 0)) continue;
						tempArr[nx][ny] += what;
						num++;
					}
					tempArr[i][j] += arr[i][j] - what * num;
				}
			}
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					arr[i][j] = tempArr[i][j];
				}
			}
			for(int i = C - 1; i > 0; i--) arr[0][i - 1] = tempArr[0][i];
			for(int i = 0; i < up; i++) arr[i + 1][0] = tempArr[i][0];
			for(int i = 0; i < C- 1; i++) arr[up][i + 1] = tempArr[up][i];
			for(int i = up; i > 0; i--) arr[i - 1][C - 1] = tempArr[i][C - 1];
			
			for(int i = 0; i < C- 1; i++) arr[down][i + 1] = tempArr[down][i];
			for(int i = down; i < R - 1; i++) arr[i + 1][C - 1] = tempArr[i][C - 1];
			for(int i = C - 1; i > 0; i--) arr[R - 1][i - 1] = tempArr[R - 1][i];
			for(int i = R - 1; i > down; i--) arr[i - 1][0] = tempArr[i][0];
			arr[up][0] = -1;
			arr[down][0] = -1;
		}
		int sum = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(j == 0 && (i == up || i == down)) continue;
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}
}
