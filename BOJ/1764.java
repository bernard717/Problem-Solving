import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String[] line = bf.readLine().split(" ");
        int N = Integer.valueOf(line[0]);
        int M = Integer.valueOf(line[1]);

        for(int i = 0; i < N; i++){
            String a = bf.readLine();
            hm.put(a, 0);
        }
        ArrayList a = new ArrayList();
        for(int i = 0; i < M; i++){
            String b = bf.readLine();
            if(hm.containsKey(b))
                a.add(b);
        }
        Collections.sort(a);
        System.out.println(a.size());
        for(int i = 0; i < a.size(); i++)
            System.out.println(a.get(i));

    }
}
