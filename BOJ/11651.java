import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
    int x, y;
    Point (int x, int y){
        this.x = x;
        this.y = y;
    }
    public int compareTo(Point that){
        if(this.x < that.x)
            return -1;
        else if(this.x == that.x){
            if(this.y < that.y)
                return -1;
            else if(this.y == that.y)
                return 0;
            else
                return 1;
            }
        else
            return 1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String first = bf.readLine();
        int num = Integer.valueOf(first);
        Point[] a = new Point[num];
        for(int i = 0; i < num; i++){
            String[] temp = bf.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            a[i] = new Point(x,y);
        }
        Arrays.sort(a, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                if(o1.y < o2.y)
                    return -1;
                else if(o1.y == o2.y){
                    if(o1.x < o2.x)
                        return -1;
                    else if(o1.x == o2.x)
                        return 0;
                    else
                        return 1;
                }
                else
                    return 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Point p : a){
            sb.append(p.x + " " + p.y + "\n");
        }
        System.out.print(sb); 
    }
}
