import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        int answer = 0;

        int len = numbers.length();

        for(int i = 1; i <= len; i++){
            int[] arr = new int[len];
            for(int j = 0; j < i; j++)
                arr[len - j - 1] = 1;
            do{
                char[] chars = new char[i];
                int idx = 0;
                for(int j = 0; j < len; j++){
                    if(arr[j] == 1)
                        chars[idx++] = numbers.charAt(j);
                }
                Arrays.sort(chars);
                do{
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; j < i; j++){
                        sb.append(chars[j]);
                    }
                    int temp = Integer.parseInt(sb.toString());
                    if(!set.contains(temp) && check(temp)) {
                        answer++;
                        set.add(temp);
                    }
                }while(nextChar(chars));
            }while(nextInt(arr));
        }

        return answer;
    }

    public boolean check(int num){
        if(num < 2)
            return false;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }

    public boolean nextInt(int[] a){
        int i = a.length - 1;
        while(i > 0 && a[i] <= a[i - 1])
            i--;
        if(i <= 0)
            return false;
        int j = a.length - 1;
        while(j >= 0 && a[j] <= a[i - 1])
            j--;
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;
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
    public boolean nextChar(char[] a){
        int i = a.length - 1;
        while(i > 0 && a[i] <= a[i - 1])
            i--;
        if(i <= 0)
            return false;
        int j = a.length - 1;
        while(j >= 0 && a[j] <= a[i - 1])
            j--;
        char temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;
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
