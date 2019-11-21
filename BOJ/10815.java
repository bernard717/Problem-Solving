import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(line[i]);
        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        String[] line2 = br.readLine().split(" ");
        for(int i = 0; i < m; i++)
            b[i] = Integer.parseInt(line2[i]);
        Arrays.sort(a);

        StringBuilder sb = new StringBuilder();
        boolean judge = false;
        for(int i = 0; i < m; i++) {
            int finding = b[i];
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (a[mid] == finding){
                    judge = true;
                    break;
                }
                if(finding < a[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            if (judge)
                sb.append("1 ");
            else
                sb.append("0 ");
            judge = false;
        }

        System.out.println(sb);
    }
}
