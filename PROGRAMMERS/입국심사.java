import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        int len = times.length;

        Arrays.sort(times);

        long st = 0;
        long en = (long)times[len - 1] * n;

        while(st <= en){
            long mid = (st + en) / 2;

            long sum = 0;

            for(int time : times)
                sum += mid / time;

            if(sum < n){
                st = mid + 1;
            }
            else if(sum >= n){
                answer = Math.min(answer, mid);
                en = mid - 1;
            }
        }

        return answer;
    }
}
