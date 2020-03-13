import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++)
            queue.add(scoville[i]);

        while(queue.size() > 1 && queue.peek() < K){
            int x = queue.poll();
            int y = queue.poll();
            int temp = x + 2 * y;
            queue.add(temp);
            answer++;
        }

        if(queue.peek() < K)
            return -1;
        
        return answer;
    }
}
