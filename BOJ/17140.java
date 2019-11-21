import java.util.*;
import java.io.*;
class Main {
	static int r, c, k;
	static int[][] arr;
	static int[] check;
	public static class Pair implements Comparable<Pair>{
		int num, cnt;
		Pair(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		public int compareTo(Pair that) {
			if(this.cnt < that.cnt)
				return -1;
			else if(this.cnt == that.cnt) {
				if(this.num < that.num)
					return -1;
				else
					return 1;
			}
			else
				return 1;
		}
	}
	static ArrayList<Pair> calR;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int r = Integer.parseInt(line[0]);
		int c = Integer.parseInt(line[1]);
		int k = Integer.parseInt(line[2]);
		arr = new int[210][210];
		check = new int[100];
		for(int i = 0; i < 3; i++) {
			String[] line2 = br.readLine().split(" ");
			for(int j = 0; j < 3; j++)
				arr[i][j] = Integer.parseInt(line2[j]);
		}
		int time = 0;
		int rowLen = 3;
		int colLen = 3;
		while(arr[r - 1][c - 1] != k && time++ <= 100) {
			if(rowLen >= colLen) {
				int max = Integer.MIN_VALUE;
				for(int i = 0; i < rowLen; i++) {
					calR = new ArrayList<Pair>();
					check = new int[101];
					for(int j = 0; j < colLen; j++) {
						if(arr[i][j] == 0) continue;
						if(check[arr[i][j]] == 0) {
							calR.add(new Pair(arr[i][j], 1));
							check[arr[i][j]] = calR.size();
						}
						else {
							calR.get(check[arr[i][j]] - 1).cnt++;
						}
					}
					Collections.sort(calR);
					for(int q = 0; q < calR.size(); q++) {
						arr[i][q * 2] = calR.get(q).num;
						arr[i][q * 2 + 1] = calR.get(q).cnt;
					}
					if(calR.size() * 2 < colLen) {
						for(int q = calR.size() * 2; q < colLen; q++)
							arr[i][q] = 0;
					}
					max = Math.max(max,  calR.size() * 2);
				}
				colLen = max;
			}
			else {
				int max = Integer.MIN_VALUE;
				for(int i = 0; i < colLen; i++) {
					ArrayList<Pair> calR = new ArrayList<Pair>();
					check = new int[101];
					for(int j = 0; j < rowLen; j++) {
						if(arr[j][i] == 0) continue;
						if(check[arr[j][i]] == 0) {
							calR.add(new Pair(arr[j][i], 1));
							check[arr[j][i]] = calR.size();
						}
						else {
							calR.get(check[arr[j][i]] - 1).cnt++;
						}
					}
					Collections.sort(calR);
					for(int q = 0; q < calR.size(); q++) {
						arr[q * 2][i] = calR.get(q).num;
						arr[q * 2 + 1][i] = calR.get(q).cnt;
					}
					if(calR.size() * 2 < rowLen) {
						for(int q = calR.size() * 2; q < rowLen; q++)
							arr[q][i] = 0;
					}
					max = Math.max(max,  calR.size() * 2);
				}
				rowLen = max;
			}
		}
		if(time > 100)
			time = -1;
		System.out.println(time);
	}
}
