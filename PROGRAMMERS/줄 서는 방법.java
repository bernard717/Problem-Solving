import java.util.*;

class Solution {
    static int[] answer;
    static ArrayList<Integer> arr;
    public int[] solution(int n, long k) {
        arr = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            arr.add(i);

        answer = new int[n];

        long next = k;

        for(int i = 0; i < n; i++){
            next = go(i, next, n - i);
        }
        return answer;
    }
    private long go(int idx, long k, int n){
        double factorial = 1;
        for(int i = 2; i < n; i++)
            factorial *= i;

        int where = (int) Math.ceil(k / factorial) - 1;

        answer[idx] = arr.get(where);
        arr.remove(where);

        return k - where * (long)factorial;
    }
}
