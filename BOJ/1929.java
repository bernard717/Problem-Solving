import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int lower = sc.nextInt();
        int upper = sc.nextInt();
        int[] primeNum = new int[upper + 1];
        boolean[] judge = new boolean[upper + 1];
        int num = 0;

        for(int i = 2; i <= upper; i++){
            if(!judge[i])
                primeNum[num++] = i;
            for(int j = i * 2; j <= upper; j += i){
                judge[j] = true;
            }
        }
        for(int i = 0; i < num; i++){
            if(primeNum[i] >= lower)
                System.out.println(primeNum[i]);
        }
    }
}
