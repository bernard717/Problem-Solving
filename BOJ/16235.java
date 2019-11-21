import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    static ArrayList<Integer>[] block;
    static int[][] a;
    static int[][] current;
    static int[] check;
    static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        block = new ArrayList[n * n + 1];
        for(int i = 1; i <= n * n; i++)
            block[i] = new ArrayList<Integer>();
        a = new int[n + 1][n + 1];
        current = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++)
                current[i][j] = 5;
        }
        for(int i = 1; i <= n; i++){
            String[] line2 = br.readLine().split(" ");
            for(int j = 1; j <= n; j++)
                a[i][j] = Integer.parseInt(line2[j - 1]);
        }
        for(int i = 0; i < m; i++){
            String[] line3 = br.readLine().split(" ");
            int x = Integer.parseInt(line3[0]);
            int y = Integer.parseInt(line3[1]);
            int age = Integer.parseInt(line3[2]);
            int where = (x - 1) * n + y;
            block[where].add(age);
        }
        for(int i = 1; i <= n * n; i++)
            Collections.sort(block[i]);
        while(k-- > 0){
            check = new int[n * n + 1];
            for(int i = 1; i <= n * n; i++){
                int num = block[i].size();
                int rest = current[(i - 1) / n + 1][(i - 1) % n + 1];
                for(int j = 0; j < num; j++){
                    int age = block[i].get(j);
                    if(rest >= age){
                        block[i].set(j, age + 1);
                        if((age + 1) % 5 == 0)
                            check[i]++;
                        rest -= age;
                    }
                    else{
                        for(int z = num - 1; z >= j; z--) {
                            rest += block[i].get(z) / 2;
                            block[i].remove(z);
                        }
                        break;
                    }
                }
                current[(i - 1) / n + 1][(i - 1) % n + 1] = rest;
            }
            for(int i = 1; i <= n * n; i++){
                if(check[i] != 0){
                    int r = (i - 1) / n + 1;
                    int c = (i - 1) % n + 1;
                    for(int f = 0; f < 8; f++){
                        int nx = r + dx[f];
                        int ny = c + dy[f];
                        if(nx >= 1 && nx <= n && ny >= 1 && ny <= n){
                            int where = (nx - 1) * n + ny;
                            for(int o = 0; o < check[i]; o++){
                                int size = block[where].size();
                                block[where].add(size, 1);
                            }
                        }
                    }
                }
            }
            for(int i = 1; i <= n * n; i++)
                Collections.sort(block[i]);
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++)
                    current[i][j] += a[i][j];
            }
        }
        int ans = 0;
        for(int i = 1; i <= n * n; i++)
            ans += block[i].size();

        System.out.println(ans);
    }
}
