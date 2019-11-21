import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		String[] line = br.readLine().split(" ");
		for(int i = 0; i < n; i++)
			a[i] = Integer.parseInt(line[i]);
		String[] line2 = br.readLine().split(" ");
		int b = Integer.parseInt(line2[0]);
		int c = Integer.parseInt(line2[1]);
		
		long ans = 0;
		
		for(int i = 0; i < n; i++) {
			if(a[i] > b)
				ans += Math.ceil(((double)a[i] - (double)b) / (double)c);
		}
		ans += n;
		System.out.println(ans);
		
		
	}
}
