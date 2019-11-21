import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hs = new HashSet<String>();
        int num = Integer.valueOf(bf.readLine());

        while(num-- > 0){
            String[] line = bf.readLine().split(" ");
            if(line[1].equals("enter")) {
                hs.add(line[0]);
            }
            else
                hs.remove(line[0]);
        }
        String[] ans = hs.toArray(new String[hs.size()]);
        Arrays.sort(ans);
        int m = ans.length;
        for(int i = m-1; i>=0; i--){
            System.out.println(ans[i]);
        }
    }
}
