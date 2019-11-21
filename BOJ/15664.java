import java.util.*;
import java.io.*;
class Main {
	static int N, M;
	static int[] a, b;
	static boolean[] isvisited;
	
	public static void func(int[] b, boolean[] isvisited, int len) {
		if(len == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(b[i] + " ");
			}
			System.out.println();
			return;
		}
		boolean[] isused = new boolean[10001];
		for(int i = 0; i < N; i++) {
			if(!isused[a[i]] && !isvisited[i]) {
				if(len > 0 && b[len - 1] > a[i]) continue;
				b[len] = a[i];
				isused[a[i]] = true;
				isvisited[i] = true;
				func(b, isvisited, len + 1);
				isvisited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);

		a = new int[N];
		String[] line2 = br.readLine().split(" ");
		for(int i = 0; i < N; i++)
			a[i] = Integer.parseInt(line2[i]);
		Arrays.sort(a);
		
		isvisited = new boolean[N];
		b = new int[M];
		
		func(b, isvisited, 0);
	}
}
