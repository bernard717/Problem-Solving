import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[] tails = new String[line.length()];
        for(int i = 0; i < line.length(); i++){
            tails[i] = line.substring(i, line.length());
        }


        Arrays.sort(tails);
        for(int i = 0; i < line.length(); i++)
            System.out.println(tails[i]);

    }
}
