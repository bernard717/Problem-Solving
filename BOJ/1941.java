import java.util.*;
import java.io.*;

class Main{
	static int[][] a;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[] brute;
	static boolean next(int[] b) {
		int i = b.length - 1;
		while(i > 0 && b[i] <= b[i - 1]) 
			i--;
		if(i <= 0) 
			return false;
		int j = b.length - 1;
		while(b[j] <= b[i - 1])
			j--;
		int temp = b[j];
		b[j] = b[i - 1];
		b[i - 1] = temp;
		
		j = b.length - 1;
		while(j > i) {
			temp = b[j];
			b[j] = b[i];
			b[i] = temp;
			j--;
			i++;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        a = new int[5][5];
        brute = new int[25];
        for(int i = 18; i < 25; i++) 
        	brute[i] = 1;
        for(int i = 0; i < 5; i++) {
        	String line = br.readLine();
        	for(int j = 0; j < 5; j++) {
        		if(line.charAt(j) == 'Y')
        			a[i][j] = 1;
        		else
        			a[i][j] = 0;
        	}
        }
        int ans = 0;
        do {
        	boolean[] visited = new boolean[25];
        	int start = 0;
        	while(brute[start] != 1) 
        		start++;
        	Queue<Integer> q = new LinkedList<Integer>();
        	q.add(start);
        	int current0 = 0;
        	int current1 = 0;
        	visited[start] = true;
        	while(!q.isEmpty()) {
        		int now = q.remove();
        		int x = now / 5;
        		int y = now % 5;
        		if(a[x][y] == 0) current0++;
        		else current1++;
        		for(int dir = 0; dir < 4; dir++) {
        			int nx = x + dx[dir];
        			int ny = y + dy[dir];
        			if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
        				continue;
        			if(visited[nx * 5 + ny]) continue;
        			if(brute[nx * 5 + ny] != 1) continue;
        			q.add(nx * 5 + ny);
        			visited[nx * 5 + ny] = true;
        		}
        	}
        	if(current0 + current1 == 7 && current0 >= 4)
        		ans++;
        }while(next(brute));
        System.out.println(ans);
    }
}
