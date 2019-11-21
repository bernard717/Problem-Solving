import java.util.*;
import java.io.*;

class Main{
	static int n, answer = 0;
	static int[][] a;
	static class Pair{
		int x;
		char y;
		Pair(int x, char y){
			this.x = x;
			this.y = y;
		}
	}
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static Point next(int dir, int x, int y) {
		if(dir == 0)
			return new Point(x, y + 1);
		else if(dir == 1)
			return new Point(x + 1, y);
		else if(dir == 2)
			return new Point(x, y - 1);
		else
			return new Point(x - 1, y);
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        int k = Integer.parseInt(br.readLine());
        while(k-- > 0) {
        	String[] line1 = br.readLine().split(" ");
        	int x = Integer.parseInt(line1[0]);
        	int y = Integer.parseInt(line1[1]);
        	a[x - 1][y - 1] = 1;
        }
        ArrayList<Pair> arr = new ArrayList<Pair>();
        int l = Integer.parseInt(br.readLine());
        while(l-- > 0) {
        	String[] line2 = br.readLine().split(" ");
        	int x = Integer.parseInt(line2[0]);
        	char y = line2[1].charAt(0);
        	arr.add(new Pair(x, y));
        }
        a[0][0] = 2;
        int nowX = 0;
        int nowY = 0;
        int time = 0;
        int change = 0;
        int dir = 0;
        int tailX = 0, tailY = 0;
        int tailNum = 0;
        ArrayList<Point> forTail = new ArrayList<Point>();
        forTail.add(new Point(nowX, nowY));
        while(true) {
        	if(change < arr.size() && arr.get(change).x == time) {
        		if(arr.get(change).y == 'L')
        			dir = (dir + 3) % 4;
        		else if(arr.get(change).y == 'D')
        			dir = (dir + 1) % 4;
        		change++;
        	}
        	Point p = next(dir, nowX, nowY);
        	nowX = p.x;
        	nowY = p.y;
        	if(nowX < 0 || nowY < 0 || nowX >= n || nowY >= n)
        		break;
        	if(a[nowX][nowY] == 2)
        		break;
        	forTail.add(new Point(nowX, nowY));
        	if(a[nowX][nowY] == 1)
        		a[nowX][nowY] = 2;
        	else if(a[nowX][nowY] == 0) {
        		a[nowX][nowY] = 2;
        		tailX = forTail.get(tailNum).x;
        		tailY = forTail.get(tailNum).y;
        		a[tailX][tailY] = 0;
        		tailNum++;
        	}
        	time++;
        }
        System.out.println(++time);
    }
}
