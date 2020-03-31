import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        s = br.readLine().split(" ");
        for(int i = 0; i < m; i++)
            b[i] = Integer.parseInt(s[i]);

        // 각 배열의 부분수열의 합을 저장하는 arrayList
        ArrayList<Long> arr1 = new ArrayList<>();
        ArrayList<Long> arr2 = new ArrayList<>();

        for(int i = 0; i < n; i++){
            long sum = 0;
            for(int j = i; j < n; j++){
                sum += a[j];
                arr1.add(sum);
            }
        }
        for(int i = 0; i < m; i++){
            long sum = 0;
            for(int j = i; j < m; j++){
                sum += b[j];
                arr2.add(sum);
            }
        }
        Collections.sort(arr1);
        Collections.sort(arr2);

        int i = 0;
        int j = arr2.size() - 1;
        long answer = 0;

        while(i < arr1.size() && j >= 0){
            long sum = arr1.get(i) + arr2.get(j);
            if(sum < T)
                i++;
            else if(sum > T)
                j--;
            else{
                long mult1 = 0;
                long mult2 = 0;
                long temp1 = arr1.get(i);
                long temp2 = arr2.get(j);
                while(i < arr1.size() && temp1 == arr1.get(i)) {
                    i++;
                    mult1++;
                }
                while(j >= 0 && temp2 == arr2.get(j)) {
                    j--;
                    mult2++;
                }
                answer += mult1 * mult2;
            }
        }
        System.out.print(answer);
    }
}
