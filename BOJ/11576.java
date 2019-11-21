import java.io.*;
import java.util.*;

public class Main {
    public static void convert(int num, int base){
        if(num == 0)
            return;
        convert(num/base, base);
        System.out.print(num%base + " ");
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int num = sc.nextInt();
        int[] array = new int[num];
        for(int i = 0; i < num; i++)
            array[i] = sc.nextInt();
        int what = 0;
        for(int i = 0; i < num; i++)
            what = what * a + array[i];
        convert(what, b);
        System.out.println();
    }
}
