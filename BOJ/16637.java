import java.util.*;
import java.io.*;
class Main {
	static int n;
	static char[] exp;
	static int ans = Integer.MIN_VALUE;
	public static int calc(char a, char b, char c) {
		int a1 = a - '0';
		int a2 = c - '0';
		if(b == '+') return a1 + a2;
		else if(b == '-') return a1 - a2;
		else return a1 * a2;
	}
	public static int calc2(int a1, char b, char c) {
		int a2 = c - '0';
		if(b == '+') return (a1 + a2);
		else if(b == '-') return (a1 - a2);
		else return (a1 * a2);
	}
	public static int calc3(int a1, char b, int a2) {
		if(b == '+') return (a1 + a2);
		else if(b == '-') return (a1 - a2);
		else return (a1 * a2);
	}
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
			temp = a[j];
			a[j] = a[i];
			a[i] = temp;
			j--;
			i++;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String line = br.readLine();
		exp = new char[n];
		
		// 홀수 자리엔 연산자, 짝수 자리엔 숫자
		for(int i = 0; i < n; i++)
			exp[i] = line.charAt(i);
		
		int[] a = new int[(n - 1) / 2];
		
		int half = ((n - 1) / 2) % 2 == 0 ? (n - 1) / 4 : (n + 1) / 4;
		for(int i = 0; i <= half; i++) {
			for(int j = 0; j < i; j++)
				a[j] = 0;
			for(int j = i; j < (n - 1) / 2; j++)
				a[j] = 1;
			do {
				boolean pass = false;
				for(int j = 1; j < (n - 1) / 2; j++) {
					if(a[j] == 0 && a[j - 1] == 0) {pass = true; break;}
				}
				if(pass) continue;
				char[] newExp = new char[n];
				for(int j = 0; j < n; j++)
					newExp[j] = exp[j];
				int[] exp2 = new int[n];
				for(int j = 0; j < (n - 1) / 2; j++) {
					if(a[j] == 0) {
						int temp = j * 2;
						exp2[temp] = calc(exp[temp], exp[temp + 1], exp[temp + 2]);
						newExp[temp] = 'f';
						newExp[temp + 1] = ' ';
						newExp[temp + 2] = ' ';
					}
				}
				int sum = 0;
				if(newExp[0] == 'f') sum = exp2[0]; 
				else sum = newExp[0] - '0';
				for(int j = 1; j < n; j+=2) {
					if(newExp[j] == ' ') continue;
					if(newExp[j + 1] == 'f') sum = calc3(sum, newExp[j], exp2[j + 1]);
					else sum = calc2(sum, newExp[j], newExp[j + 1]);
				}
				ans = Math.max(ans,  sum);
			}while(next(a));
		}
		System.out.println(ans);
	}
}
