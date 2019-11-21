import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] a = new int[k+1];
        String[] newline = br.readLine().split(" ");
        for(int i = 1; i <= k; i++)
            a[i] = Integer.parseInt(newline[i-1]);
        ArrayList<Integer>[] arrayLists = (ArrayList<Integer>[]) new ArrayList[k+1];
        for(int i = 1; i <= k; i++)
            arrayLists[i] = new ArrayList<Integer>();
        for(int i = 1; i <= k; i++)
            arrayLists[a[i]].add(i);
        int[] now = new int[n+1];
        boolean right = true;
        int newone = 1;

        for(int i = 1; i <= k; i++) {
            for (int j = 1; j < i && j < n + 1; j++) {
                if (now[j] == a[i]){
                    right = false;
                    break;}
            }
            if (right)
                now[newone++] = a[i];
            right = true;
            if(newone == n + 1)
                break;
        }

        int point = n + 1;
        boolean judge = false;
        int ans = 0;
        while(point <= k){
            for(int i = 1; i <= n; i++){
                if(a[point] == now[i]){
                    judge = true;
                    break;
                }
            }
            int max = -1;
            int change = 0;
            if(!judge){
                for(int i = 1; i <= n; i++){
                    if(arrayLists[now[i]].size() != 1) {
                        int t = 1;
                        int temp = arrayLists[now[i]].get(1);
                        while (temp < point && t < arrayLists[now[i]].size()) {
                            temp = arrayLists[now[i]].get(t);
                            t++;
                        }
                        if (temp < point)
                            temp = 10000;
                        if (max < temp) {
                            max = temp;
                            change = i;
                        }
                    }
                    else{
                        change = i;
                        break;}
                }
                now[change] = a[point];
                ans++;
            }
            point++;
            judge = false;
        }

        System.out.println(ans);
    }
}
