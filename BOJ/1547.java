import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        while(m-- > 0) {
        	String[] line = br.readLine().split(" ");
        	int a = Integer.parseInt(line[0]);
        	int b = Integer.parseInt(line[1]);
        	int i;
        	for(i = 0; i < 3; i++) {
        		if(arr[i] == a)
        			break;
        	}
        	int j;
        	for(j = 0; j < 3; j++) {
        		if(arr[j] == b)
        			break;
        	}
        	int temp = arr[i];
        	arr[i] = arr[j];
        	arr[j] = temp;
        }
        System.out.println(arr[0]);
    }
}
