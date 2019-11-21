import java.io.*;
import java.util.*;

public class Main {
    public static boolean prime(int n){
        if(n < 2)
            return false;
        else{
            for(int i = 2; i * i <= n; i++){
                if(n % i == 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[num];
        int ans = 0;
        for(int i = 0; i < num; i++) {
            array[i] = sc.nextInt();
            if (prime(array[i]))
                ans++;
        }
        System.out.println(ans);
    }
}
