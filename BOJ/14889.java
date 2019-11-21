import java.util.*;
        import java.io.*;
public class Main {
    static int[][] a;
    static int n;
    static int[] d;
    public static void swap(int x, int y){
        int temp = d[x];
        d[x] = d[y];
        d[y] = temp;
    }
    public static boolean next(){
        int i = n - 1;
        while(i > 0 && d[i] <= d[i - 1])
            i--;
        if(i <= 0)
            return false;
        int j = n - 1;
        while(j >= i && d[j] <= d[i - 1])
            j--;
        swap(j, i - 1);
        j = n - 1;
        while(i < j){
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(line[j]);
        }
        d = new int[n];
        for(int i = 0; i < n / 2; i++)
            d[i] = 0;
        for(int i = n / 2; i < n; i++)
            d[i] = 1;
        int min = Integer.MAX_VALUE;
        do{
            int team1 = 0;
            int team2 = 0;
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    if(d[i] == d[j]){
                        if(d[i] == 0)
                            team1 += (a[i][j] + a[j][i]);
                        else
                            team2 += (a[i][j] + a[j][i]);
                    }
                }
            }
            int diff = Math.abs(team1 - team2);
            min = Math.min(diff, min);
        }while(next());
        System.out.println(min);
    }
}
