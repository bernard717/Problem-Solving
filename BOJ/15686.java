import java.lang.reflect.Array;
import java.nio.charset.IllegalCharsetNameException;
import java.util.*;
import java.io.*;
public class Main {
    static int[][] a;
    static int[][] dist;
    static int[][] everyDist;
    static ArrayList<Integer> house;
    static ArrayList<Integer> chicken;
    static int n;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static boolean next(int[] combi){
        int i = combi.length - 1;
        while(i > 0 && combi[i] <= combi[i - 1])
            i--;
        if(i <= 0)
            return false;
        int j = combi.length - 1;
        while(combi[j] <= combi[i - 1])
            j--;
        int temp = combi[j];
        combi[j] = combi[i - 1];
        combi[i - 1] = temp;
        j = combi.length - 1;
        while(j > i){
            temp = combi[j];
            combi[j] = combi[i];
            combi[i] = temp;
            i++;
            j--;
        }
        return true;
    }
    public static void bfs(int x, int y){
        int where = house.indexOf(x * n + y);
        boolean[][] check = new boolean[n][n];
        everyDist = new int[n][n];
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        check[x][y] = true;
        everyDist[x][y] = 0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            for(int k = 0; k < 4; k++){
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                    if(!check[nx][ny]){
                        check[nx][ny] = true;
                        everyDist[nx][ny] = everyDist[p.x][p.y] + 1;
                        q.add(new Pair(nx, ny));
                        if(a[nx][ny] == 2)
                            dist[where][chicken.indexOf(nx * n + ny)] = everyDist[nx][ny];
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        a = new int[n][n];
        int houseNum = 0;
        int chickenNum = 0;
        house = new ArrayList<Integer>();
        chicken = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            String[] line2 = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                int what = Integer.parseInt(line2[j]);
                if(what == 1) {
                    houseNum++;
                    house.add(i * n + j);
                }
                else if(what == 2) {
                    chickenNum++;
                    chicken.add(i * n + j);
                }
                a[i][j] = what;
            }
        }
        dist = new int[houseNum][chickenNum];
        for(Integer p : house)
            bfs(p / n, p % n);
        int[] combi = new int[chickenNum];
        for(int i = 0; i < m; i++)
            combi[i] = 0;
        for(int i = m; i < chickenNum; i++)
            combi[i] = 1;
        int sum = Integer.MAX_VALUE;
        do{
            boolean[] die = new boolean[chickenNum];
            for(int i = 0; i < chickenNum; i++){
                if(combi[i] == 1)
                    die[i] = true;
            }
            int min = Integer.MAX_VALUE;
            int temp = 0;
            for(int i = 0; i < houseNum; i++){
                for(int j = 0; j < chickenNum; j++){
                    if(!die[j])
                        min = Math.min(min, dist[i][j]);
                }
                temp += min;
                min = Integer.MAX_VALUE;
            }
            sum = Math.min(temp, sum);
        }while(next(combi));
        System.out.println(sum);
    }
}
