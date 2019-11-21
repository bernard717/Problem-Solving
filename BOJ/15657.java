import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main {
    static boolean[] used;
    static int[] num;
    static ArrayList<Integer> arr;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        String[] line2 = br.readLine().split(" ");
        num = new int[n + 1];
        for(int i = 1; i <= n; i++)
            num[i] = Integer.parseInt(line2[i - 1]);
        used = new boolean[n + 1];
        arr = new ArrayList<Integer>();
        int k = 0;
        Arrays.sort(num);
        go(k);
        System.out.print(sb);
    }
    public static void go(int k){
        if(k == m){
            for(int i = 0; i < arr.size(); i++)
                sb.append(arr.get(i) + " ");
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= n; i++){
                if (arr.size() > 0 && arr.get(arr.size() - 1) > num[i]) continue;
                arr.add(num[i]);
                used[i] = true;
                go(k + 1);
                used[i] = false;
                arr.remove(arr.size() - 1);

        }
    }
}
