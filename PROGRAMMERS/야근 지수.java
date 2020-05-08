import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i = 0; i < works.length; i++)
            pq.add(works[i]);
        
        for(int i = 0; i < n; i++){
            int temp = pq.remove();
            if(temp <= 0) break;
            pq.add(temp - 1);
        }
        
        while(!pq.isEmpty())
            answer += Math.pow(pq.remove(), 2);
        
        
        return answer;
    }
}
