import java.util.*;
class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        Arrays.sort(budgets);
        int n = budgets.length;
        int st = 0;
        int en = budgets[n - 1];
        int mid = (st + en) / 2;
        while(st <= en){
            int sum = 0;
            mid = (st + en) / 2;
            for(int i = 0; i < n; i++){
                if(budgets[i] <= mid)
                    sum += budgets[i];
                else
                    sum += mid;
            }
           
                if(sum < M)
                    st = mid + 1;
                    
                else if(sum > M)
                    en = mid - 1;
                else
                    return mid;
            
        }
        return (st+en) / 2;
    }
}
