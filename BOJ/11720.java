import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String a = sc.nextLine();
        int sum = 0;
        for(int i = 0; i < num; i++)
            sum += Integer.parseInt(a.substring(i, i+1));
        System.out.println(sum);
    }
}
