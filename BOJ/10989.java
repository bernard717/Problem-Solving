import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());
            cnt[temp]++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1; i <= 10000; i++){
            if(cnt[i] > 0) {
                for (int j = 0; j < cnt[i]; j++)
                    bw.write(Integer.toString(i) + "\n");
            }
        }
        
        bw.close();
    }
}
