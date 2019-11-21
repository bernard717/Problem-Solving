import java.util.*;
import java.io.*;
class Main {
	static int n;
	static int[] population;
	static ArrayList<Integer>[] connect;
	static int ans = Integer.MAX_VALUE;
	
	public static boolean next(int[] a) {
		int i = a.length - 1;
		while(i > 0 && a[i - 1] >= a[i])
			i--;
		if(i <= 0) return false;
		
		int j = a.length - 1;
		while(a[j] <= a[i - 1])
			j--;
		int temp = a[j];
		a[j] = a[i - 1];
		a[i - 1] = temp;
		
		j = a.length - 1;
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return true;
	}
	
	public static void check(boolean[] isvisited, int[] a, int standard, int now) {
		for(int i : connect[now]) {
			if(isvisited[i]) continue;
			if(a[i - 1] != a[standard - 1]) continue;
			isvisited[i] = true;
			check(isvisited, a, standard, i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		population = new int[n + 1];
		connect = (ArrayList<Integer>[]) new ArrayList[n + 1];
		for(int i = 0; i <= n; i++)
			connect[i] = new ArrayList<Integer>();
		
		String[] line = br.readLine().split(" ");
		for(int i = 1; i <= n; i++)
			population[i] = Integer.parseInt(line[i - 1]);
		
		for(int i = 1; i <= n; i++) {
			String[] line2 = br.readLine().split(" ");
			int temp = Integer.parseInt(line2[0]);
			for(int j = 1; j <= temp; j++)
				connect[i].add(Integer.parseInt(line2[j]));
		}
		int half = n % 2 == 0 ? n / 2 : (n - 1) / 2;
		int[] a = new int[n];
		for(int i = 1; i <= half; i++) {
			for(int j = 0; j < i; j++)
				a[j] = 0;
			for(int j = i; j < n; j++)
				a[j] = 1;
			do {
				boolean judge = true;
				// a[i] == 0인 것 확인
				int[] zero = new int[i];
				int idx = 0;
				for(int j = 0; j < n; j++) {
					if(a[j] == 0) zero[idx++] = j + 1; 
				}
				boolean[] isvisited = new boolean[n + 1];
				isvisited[zero[0]] = true;
				check(isvisited, a, zero[0], zero[0]);
				for(int j = 0; j < idx; j++) {
					if(!isvisited[zero[j]]) {
						judge = false;
						break;
					}
				}
				if(!judge) continue;
				// a[i] == 1인 것 확인
				int[] one = new int[n - i];
				idx = 0;
				for(int j = 0; j < n; j++) {
					if(a[j] == 1) one[idx++] = j + 1; 
				}
				isvisited = new boolean[n + 1];
				isvisited[one[0]] = true;
				check(isvisited, a, one[0], one[0]);
				for(int j = 0; j < idx; j++) {
					if(!isvisited[one[j]]) {
						judge = false;
						break;
					}
				}
				if(!judge) continue;
				int sum1 = 0;
				int sum2 = 0;
				for(int j = 0; j < n; j++) {
					if(a[j] == 0) sum1 += population[j + 1];
					else sum2 += population[j + 1];
				}
				ans = Math.min(Math.abs(sum1 - sum2), ans);
			}while(next(a));
		}
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}
}
