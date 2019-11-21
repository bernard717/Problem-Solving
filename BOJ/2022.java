import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        double x = Double.parseDouble(line[0]);
        double y = Double.parseDouble(line[1]);
        double c = Double.parseDouble(line[2]);
        double left = 0;
        double right = Math.min(x, y);
        double d = 0;
        while(Math.abs(right - left) > 1e-6){
            d = left + (right - left) / 2;
            double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(d, 2));
            double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(d, 2));
            double h = h1 * h2 / (h1 + h2);
            if(h > c)
                left = d;
            else
                right = d;
        }
        System.out.format("%.3f\n", d);
    }
}
