import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        BigInteger a1 = BigInteger.ZERO;
        BigInteger a2 = BigInteger.ONE;
        BigInteger a3 = BigInteger.ZERO;
        for(int i = 2; i <= num; i++){
            a3 = a1.add(a2);
            a1 = a2;
            a2 = a3;
        }
        if(num == 1)
            a3 = BigInteger.ONE;

        System.out.println(a3);
    }
}
