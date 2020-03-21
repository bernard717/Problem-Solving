import java.util.*;

class Solution {
    class Pair{
        int max, num;
        public Pair(int max, int num){
            this.max = max;
            this.num = num;
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {

        int[] days = new int[progresses.length];
        Deque<Pair> deque = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            if((100 - progresses[i]) % speeds[i] == 0)
                days[i] = (100 - progresses[i]) / speeds[i];
            else
                days[i] = (100 - progresses[i]) / speeds[i] + 1;
        }
        deque.add(new Pair(days[0], 1));
        for(int i = 1; i < days.length; i++){
            if(deque.getLast().max < days[i])
                deque.add(new Pair(days[i], 1));
            else
                deque.getLast().num++;
        }
        int[] answer = new int[deque.size()];
        int idx = 0;

        for(Pair p : deque)
            answer[idx++] = p.num;

        return answer;
    }
}
