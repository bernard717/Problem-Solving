import java.util.*;

class Solution {
    class Pair{
        int weight, time;
        public Pair(int weight, int time){
            this.weight = weight;
            this.time = time;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int truckNum = truck_weights.length;

        int idx = 0;

        Queue<Pair> onBridge = new LinkedList<Pair>();
        int totalWeight = 0;
        int time = 0;

        onBridge.add(new Pair(truck_weights[idx++], 0));

        while(idx < truckNum){
            time++;
            totalWeight = 0;
            for(Pair p : onBridge){
                p.time++;
                totalWeight += p.weight;
            }

            if(!onBridge.isEmpty() && onBridge.peek().time == bridge_length) {
                Pair removed = onBridge.peek();
                totalWeight -= removed.weight;
                onBridge.remove();
            }
            if(totalWeight + truck_weights[idx] <= weight)
                onBridge.add(new Pair(truck_weights[idx++], 0));
        }
        while(!onBridge.isEmpty()){
            time++;
            for(Pair p : onBridge)
                p.time++;
            if(onBridge.peek().time == bridge_length)
                onBridge.remove();
        }

        return time + 1;
    }
}
