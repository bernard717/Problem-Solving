import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        long ans = 0;
        int st1 = a.length - 1;
        int st2 = b.length - 1;
        int st3 = c.length - 1;
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int[] num1 = new int[a.length];
        int[] num3 = new int[c.length];
        Set<Integer> set = new HashSet<>();
        // 현재 idx까지 서로 다른 수의 개수를 유지하는 배열
        for(int i = 0; i < a.length; i++){
            set.add(a[i]);
            num1[i] = set.size();
        }
        set = new HashSet<>();
        for(int i = 0; i < c.length; i++){
            set.add(c[i]);
            num3[i] = set.size();
        }

        while(st1 >= 0 && st2 >= 0 && st3 >= 0){
            int n1 = a[st1];
            int n2 = b[st2];
            int n3 = c[st3];
            if(n2 >= n1 && n2 >= n3){
                ans += (long)(num1[st1]) * (long)(num3[st3]);
                System.out.println(ans);
                while(st2 >= 0 && b[st2] == n2)
                    st2--;
            }
            else{ 
                if(n2 < n1){
                    while(st1 >= 0 && a[st1] > n2)
                        st1--;
                    if(st1 > 0 && a[st1 - 1] == a[st1]){
                        int temp = a[st1];
                        while(st1 >= 0 && a[st1] == temp)
                            st1--;
                        st1++;
                    }
                }
                if(n2 < n3){
                    while(st3 >= 0 && c[st3] > n2)
                        st3--;
                    if(st3 > 0 && c[st3 - 1] == c[st3]){
                        int temp = c[st3];
                        while(st3 >= 0 && c[st3] == temp)
                            st3--;
                        st3++;
                    }
                }
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
