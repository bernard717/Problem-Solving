import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer, ArrayList> map = new HashMap<>();
        for(int i = 0; i < cost.length; i++){
            int now = cost[i];
            if(map.containsKey(now)){
                map.get(now).add(i + 1);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i + 1);
                map.put(now, temp);
            }
        }
        for(int i = 0; i < cost.length; i++){
            int diff = money - cost[i];
            if(diff == cost[i]){
                if(map.get(diff).size() < 2)
                    continue;
                else{
                    ArrayList<Integer> temp = map.get(diff);
                    System.out.println(temp.get(0) + " " + temp.get(1));
                    return;
                }
            }
            else{
                if(map.containsKey(diff)){
                    ArrayList<Integer> temp1 = map.get(cost[i]);
                    ArrayList<Integer> temp2 = map.get(diff);
                    int idx1 = temp1.get(0);
                    int idx2 = temp2.get(0);
                    if(idx1 < idx2)
                        System.out.println(idx1 + " " + idx2);
                    else
                        System.out.println(idx2 + " " + idx1);
                    return;
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
