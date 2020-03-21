import java.util.*;

class Solution {
    class Pair{
        int id, priority;
        public Pair(int id, int priority){
            this.id = id;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 1;

        Queue<Pair> tasks = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++)
            tasks.add(new Pair(i, priorities[i]));

        while(!tasks.isEmpty()){
            int now = tasks.peek().priority;
            boolean flag = false;
            for(Pair p : tasks){
                if(p.priority > now){
                    flag = true;
                    break;
                }
            }
            if(flag){
                Pair p = tasks.remove();
                tasks.add(p);
            }
            else {
                Pair p = tasks.remove();
                if(p.id == location)
                    return answer;
                else
                    answer++;
            }
        }



        return answer;
    }
}
