import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static class Pair implements Comparable<Pair>{
        char name;
        int num;
        public Pair(char name, int num){
            this.name = name;
            this.num = num;
        }

        @Override
        public int compareTo(Pair that) {
            if(this.num < that.num)
                return 1;
            else
                return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Pair> pairs = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String s = br.readLine();

            for(int j = 0; j < s.length(); j++){
                char name = s.charAt(j);
                int num = (int) Math.pow(10, s.length() - j - 1);
                boolean flag = false;
                for(Pair p : pairs){
                    if(name == p.name) {
                        p.num += num;
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    pairs.add(new Pair(name, num));
            }
        }
        Collections.sort(pairs);
        int sum = 0;
        int idx = 9;
        for(Pair p : pairs)
            sum += p.num * idx--;
        System.out.print(sum);
    }
}
