import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal num1 = sc.nextBigDecimal();
        int num2 = sc.nextInt();
        BigDecimal ans = num1.pow(num2);
        System.out.println(ans.toPlainString());
    }
}
