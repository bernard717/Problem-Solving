import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        while(num-- > 0){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            System.out.println(num1+num2);
            sc.nextLine();
        }

    }
}
