import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int solution(int[][] baseball) {
        int answer = 0;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] perm = {0, 0, 0, 0, 0, 0, 1, 1, 1};

        ArrayList<String> possible = new ArrayList<>();
        do{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++){
                if(perm[i] == 1)
                    sb.append(arr[i]);
            }
            String s = sb.toString();
            char[] chars = s.toCharArray();
            do{
                possible.add(String.valueOf(chars));
            }while (next(chars));
        }while(next(perm));

        boolean[] check = new boolean[possible.size()];

        for(int i = 0; i < baseball.length; i++){
            int temp = baseball[i][0];
            char first = (char) (temp / 100 + '0');
            char second = (char)((temp % 100) / 10  + '0');
            char third = (char)((temp % 100) % 10  + '0');

            int strike = baseball[i][1];
            int ball = baseball[i][2];

            for(int j = 0; j < possible.size(); j++){
                if(check[j])
                    continue;
                String now = possible.get(j);

                int sum = 0;
                if(now.charAt(0) == first) sum++;
                if(now.charAt(1) == second) sum++;
                if(now.charAt(2) == third) sum++;
                if(sum != strike) {
                    check[j] = true;
                    continue;
                }
                sum = 0;
                if(now.contains(String.valueOf(first)) && now.charAt(0) != first) sum++;
                if(now.contains(String.valueOf(second)) && now.charAt(1) != second) sum++;
                if(now.contains(String.valueOf(third)) && now.charAt(2) != third) sum++;
                if(sum != ball)
                    check[j] = true;
            }
        }
        for(int i = 0; i < check.length; i++){
            if(!check[i])
                answer++;
        }


        return answer;
    }
    public boolean next(int[] a){
        int i = a.length - 1;
        while(i > 0 && a[i] <= a[i - 1])
            i--;
        if(i <= 0)
            return false;
        int j = a.length - 1;
        while(j > 0 && a[j] <= a[i - 1])
            j--;
        int temp = a[j];
        a[j] = a[i - 1];
        a[i - 1] = temp;
        j = a.length - 1;
        while(i < j){
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }
    public boolean next(char[] a){
        int i = a.length - 1;
        while(i > 0 && a[i] <= a[i - 1])
            i--;
        if(i <= 0)
            return false;
        int j = a.length - 1;
        while(j > 0 && a[j] <= a[i - 1])
            j--;
        char temp = a[j];
        a[j] = a[i - 1];
        a[i - 1] = temp;
        j = a.length - 1;
        while(i < j){
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
