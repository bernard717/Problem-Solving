import java.io.*;
import java.util.*;
class Main {	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] line = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
        	arr[i] = Integer.parseInt(line[i]);
        
        line = br.readLine().split(" ");
        int[] operators = new int[4];
        for(int i = 0; i < 4; i++)
        	operators[i] = Integer.parseInt(line[i]);
        
        int[] perm = new int[N - 1];
        int idx = 0;
        for(int i = 0; i < 4; i++) {
        	for(int j = 0; j < operators[i]; j++)
        		perm[idx++] = i; 
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        do {
        	int now = arr[0];
        	for(int i = 0; i <= N - 2; i++) 
        		now = calc(now, arr[i + 1], perm[i]);
        	
        	min = Math.min(now,  min);
        	max = Math.max(now,  max);
        	
        }while(next(perm));
        
        System.out.println(max);
        System.out.print(min);
    }
    static boolean next(int[] a) {
    	int i = a.length - 1;
    	while(i > 0 && a[i - 1] >= a[i])
    		i--;
    	if(i <= 0)
    		return false;
    	int j = a.length - 1;
    	while(a[j] <= a[i - 1])
    		j--;
    	int temp = a[j];
    	a[j] = a[i - 1];
    	a[i - 1] = temp;
    	j = a.length - 1;
    	while(j > i) {
    		temp = a[j];
    		a[j] = a[i];
    		a[i] = temp;
    		j--;
    		i++;
    	}
    	return true;
    }
    static int calc(int x, int y, int op) {
    	if(op == 0)
    		return x + y;
    	if(op == 1)
    		return x - y;
    	if(op == 2)
    		return x * y;
    	else {
    		if(x < 0) {
    			x *= -1;
    			return (x / y) * -1;
    		}
    		else
    			return x / y;
    	}
    }
}
