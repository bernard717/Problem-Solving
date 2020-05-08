import java.io.*;
import java.util.*;
class Main {	
	static int N, M; 
	static int[][] board;
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
         
        ArrayList<Pair> chickens = new ArrayList<>();
        ArrayList<Pair> houses = new ArrayList<>();
        
        board = new int[N][N];
        for(int i = 0; i < N; i++) {
        	line = br.readLine().split(" ");
        	for(int j = 0; j < N; j++) {
        		int temp = Integer.parseInt(line[j]);
        		if(temp == 1)
        			houses.add(new Pair(i, j));
        		else if(temp == 2) 
        			chickens.add(new Pair(i, j));
        		board[i][j] = temp;
        	}
        }
        
        int houseNum = houses.size();
        int chickenNum = chickens.size();
        
        int[][] dist = new int[houseNum][chickenNum];
        
        for(int i = 0; i < houseNum; i++) {
        	for(int j = 0; j < chickenNum; j++) {
        		Pair p = houses.get(i);
        		Pair q = chickens.get(j);
        		dist[i][j] = Math.abs(p.x - q.x) + Math.abs(p.y - q.y);
        	}
        }
        
        int[] perm = new int[chickenNum];
        for(int i = 0; i < M; i++)
        	perm[chickenNum - i - 1] = 1;
        
        int min = Integer.MAX_VALUE;
        do {
        	int sum = 0;
        	for(int i = 0; i < houseNum; i++) {
        		int tempMin = Integer.MAX_VALUE;
        		for(int j = 0; j < chickenNum; j++) {
        			if(perm[j] == 0) continue;
        			tempMin = Math.min(tempMin,  dist[i][j]);
        		}
        		sum += tempMin;
        	}
        	min = Math.min(sum, min);
        }while(next(perm));
        
        System.out.print(min);
    }
	private static boolean next(int[] a) {
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
		while(i < j) {
			temp = a[j];
			a[j] = a[i];
			a[i] = temp;
			j--;
			i++;
		}
		return true;
	}
}
