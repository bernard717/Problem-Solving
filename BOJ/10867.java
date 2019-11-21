import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a =  new int[n];
        String[] line = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(line[i]);
        Arrays.sort(a);
        StringBuilder sb =  new StringBuilder();
        int temp = a[0];
        bw.write(a[0] + " ");
        for(int i = 0; i < n; i++){
            if(a[i] == temp)
                continue;
            else{
                bw.write(a[i] + " ");
                temp = a[i];
            }
        }
        bw.close();
    }
}
