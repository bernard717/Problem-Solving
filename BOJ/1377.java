import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num1 = n;
        int num2 = n;
        int[] array = new int[n];
        int[] origin = new int[1000001];
        int[] now = new int[1000001];
        int k = 0;
        while(n-- > 0) {
            int temp = Integer.parseInt(br.readLine());
            origin[temp] = k;
            array[k++] = temp;
        }

        Arrays.sort(array);
        int j = 0;
        while(num2-- > 0)
            now[array[j]] = j++;

        int diff = Integer.MIN_VALUE;
        int temp = 0;
        for(int i = 0; i < 1000000; i++){
            temp = origin[i] - now[i];

            if(diff < temp){
                diff = temp;
            }
        }

        System.out.println(diff + 1);
    }
}
