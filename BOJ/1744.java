import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> plus = new ArrayList<Integer>();
        ArrayList<Integer> minus = new ArrayList<Integer>();
        int zero = 0;
        int one = 0;
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp > 0){
                if(temp == 1)
                    one++;
                plus.add(temp);
            }
            else if(temp < 0)
                minus.add(temp);
            else
                zero++;
        }
        int sum = 0;
        Collections.sort(minus);
        if(minus.size() % 2 == 0){
            for(int i = 0; i < minus.size(); i += 2)
                sum += minus.get(i) * minus.get(i+1);
        }
        else{
            if(zero != 0){
                for(int i = 0; i < minus.size() - 1; i += 2)
                    sum += minus.get(i) * minus.get(i+1);
            }
            else{
                for(int i = 0; i < minus.size() - 1; i += 2)
                    sum += minus.get(i) * minus.get(i+1);
                sum += minus.get(minus.size()-1);
            }
        }
        Collections.sort(plus);
        if((plus.size() - one) % 2 == 0){
            for(int i = one; i < plus.size(); i += 2)
                sum += plus.get(i) * plus.get(i+1);
            sum += one;
        }
        else{
            for(int i = one + 1; i < plus.size() - 1; i += 2)
                sum += plus.get(i) * plus.get(i+1);
            sum += one;
            sum += plus.get(one);
        }

        System.out.println(sum);
    }
}
