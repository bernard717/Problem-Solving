import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static int makingOne(int n, int[] d){
        int temp;
        if(d[n] > 0)
            return d[n];
        if(n == 1){
            d[1] = 0;
            return 0;
        }

        if(d[n-1] > 0)
            temp = d[n-1] + 1;
        else
            temp = makingOne(n-1, d) + 1;

        if(n % 3 == 0){
            if(d[n/3] > 0){
                if(temp > d[n/3] + 1)
                    temp = d[n/3] + 1;
            }
            else
                temp = Math.min(makingOne(n/3, d) + 1, temp);
        }
        if(n % 2 == 0){
            if(d[n/2] > 0){
                if(temp > d[n/2] + 1)
                    temp = d[n/2] + 1;
            }
            else
                temp = Math.min(makingOne(n/2, d) + 1, temp);
        }
        d[n] = temp;
        return temp;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] d = new int[num + 1];
        System.out.println(makingOne(num, d));

    }
}
