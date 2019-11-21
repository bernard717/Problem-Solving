import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main {
    static boolean[] used;
    static ArrayList<Integer> arr;
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        used = new boolean[n + 1];
        arr = new ArrayList<Integer>();
        int k = 0;
        go(k);
    }
    public static void go(int k){
        if(k == m){
            for(int i = 0; i < arr.size(); i++)
                System.out.print(arr.get(i) + " ");
            System.out.println();
        }
        for(int i = 1; i <= n; i++){
            if(!used[i]) {
                if(arr.size() > 0 && arr.get(arr.size() - 1) > i) continue;
                arr.add(i);
                used[i] = true;
                go(k + 1);
                arr.remove(arr.size() - 1);
                used[i] = false;
            }
        }
    }
}
