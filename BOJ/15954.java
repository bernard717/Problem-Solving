import java.util.*;
import java.io.*;
public class Main {
    static int[] array;
    static int n, k;
    static double min = 100000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        k = Integer.parseInt(temp[1]);

        array = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(line[i]);

        double mean1;
        double var;
        while (k <= n) {
            for (int i = 0; i + k <= n; i++) {
                mean1 = mean(i, i + k - 1);
                var = variance(i, i + k - 1, mean1);
                min = Math.min(var, min);
            }
            k++;
        }
        System.out.println(min);
    }

    public static double mean(int start, int end){
        double sum = 0;
        for(int i = start; i <= end; i++)
            sum += array[i];
        double divider = end - start + 1;
        return sum / divider;
    }

    public static double variance(int start, int end, double mean){
        double sum = 0;
        double divider = end - start + 1;
        for(int i = start; i <= end; i++){
            sum += Math.pow(array[i] - mean, 2);
        }
        return Math.sqrt(sum / divider);
    }
}
