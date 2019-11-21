import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static int[] d;

    public static int makingOne(int n){
        if(n <= 1)
            return 1;
        int temp1, temp2;
        temp1 = d[n-1] > 0 ? d[n - 1] : makingOne(n - 1);
        temp2 = d[n-2] > 0 ? d[n - 2] : makingOne(n - 2);

        d[n] = temp1 + 2 * temp2;
        d[n] %= 10007;
        return d[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        d = new int[num + 1];
        System.out.println(makingOne(num));

    }
}
