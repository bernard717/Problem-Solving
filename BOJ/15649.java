import java.util.*;
import java.io.*;

class Main{
	static int n, m, k;
	static int[] arr;
	static ArrayList<Integer> per;
	static void go(int k) {
		if(k == m) {
			for(int i = 0; i < k; i++) 
				System.out.print(per.get(i) + " ");
			System.out.println();
		}
		for(int i = 1; i <= n; i++) {
			if(arr[i] == 0) {
				per.add(i);
				arr[i] = 1;
				go(k + 1);
				arr[i] = 0;
				per.remove(per.size() - 1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        arr = new int[n + 1];
        k = 0;
        per = new ArrayList<Integer>();
        go(k);
        

    }
}
