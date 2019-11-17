import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String color1 = bf.readLine();
        String color2 = bf.readLine();
        String color3 = bf.readLine();

        hm.put("black", 0);
        hm.put("brown", 1);
        hm.put("red", 2);
        hm.put("orange", 3);
        hm.put("yellow", 4);
        hm.put("green", 5);
        hm.put("blue", 6);
        hm.put("violet", 7);
        hm.put("grey", 8);
        hm.put("white", 9);

        long ans = (long) ((hm.get(color1) * 10 + hm.get(color2)) * Math.pow(10, hm.get(color3)));
        System.out.println(ans);

    }
}
