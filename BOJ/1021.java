import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] pop = new int[m];

        s = br.readLine().split(" ");
        for(int i = 0; i < m; i++)
            pop[i] = Integer.parseInt(s[i]);

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            list.add(i);

        int idx = 0;
        int sum = 0;
        while(idx < m){
            int left = list.indexOf(pop[idx]);
            int right = list.size() - list.indexOf(pop[idx]);

            List<Integer> temp = new ArrayList<>();

            if(left < right){
                for(int i = left; i < list.size(); i++)
                    temp.add(list.get(i));
                for(int i = 0; i < left; i++)
                    temp.add(list.get(i));
                sum += left;
            }
            else{
                for(int i = left; i < list.size(); i++)
                    temp.add(list.get(i));
                for(int i = 0; i < left; i++)
                    temp.add(list.get(i));
                sum += right;
            }
            list = temp.subList(1, temp.size());
            idx++;
        }
        System.out.print(sum);
    }
}
