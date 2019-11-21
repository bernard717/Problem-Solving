import java.util.*;
import java.io.*;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int f = Integer.parseInt(line[0]);
		int s = Integer.parseInt(line[1]);
		int g = Integer.parseInt(line[2]);
		int u = Integer.parseInt(line[3]);
		int d = Integer.parseInt(line[4]);
		
		int[] dist = new int[f + 1];
		int[] dx = {u, -1 * d};
		
		for(int i = 0; i <= f; i++)
			dist[i] = -1;
		
		dist[s] = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(s);

		while(!q.isEmpty()) {
			int x = q.remove();
			for(int k = 0; k < 2; k++) {
				int nx = x + dx[k];
				if(nx < 1 || nx > f) continue;
				if(dist[nx] != -1) continue;
				dist[nx] = dist[x] + 1;
				q.add(nx);
			}
		}
		if(dist[g] == -1) System.out.println("use the stairs");
		else System.out.println(dist[g]);
	}
}
