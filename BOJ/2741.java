import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }
}
