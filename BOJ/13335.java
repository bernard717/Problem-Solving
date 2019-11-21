import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int w = Integer.parseInt(line1[1]);
        int l = Integer.parseInt(line1[2]);
        int[] weight = new int[n];
        String[] line2 = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
        	weight[i] = Integer.parseInt(line2[i]);
        int[] truck = new int[n];
        int time = 0;
        int start = 0;
        int end = -1;
        int currentNum = 0;
        int currentWeight = 0;
        while(true) {
        	int temp = start;
        	for(int i = temp; i <= end; i++) {
        		truck[i]++;
        		if(truck[i] > w) {
        			start++;
        			currentNum--;
        			currentWeight -= weight[i];
        		}
        	}
        	if(start >= n)
        		break;
        	if(end + 1 < n && currentNum + 1 <= w && currentWeight + weight[end + 1] <= l) {
        		currentNum++;
        		currentWeight += weight[end + 1];
        		truck[end + 1] = 1;
        		end++;
        	}
        	time++;
        }
        System.out.println(time + 1);
    }
}
