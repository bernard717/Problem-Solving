import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        while(num-- > 0){
            String[] a= br.readLine().split(",");
            System.out.println(Integer.parseInt(a[0]) + Integer.parseInt(a[1]));
        }

    }
}
