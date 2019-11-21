import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(String op : operations){
            String[] line = op.split(" ");
            if(line[0].equals("I")){
                System.out.println("더하기");
                int temp = Integer.parseInt(line[1]);
                minQ.offer(temp);
                maxQ.offer(temp);
            }
            else if(line[0].equals("D")){
                if(maxQ.isEmpty()) continue;
                System.out.println("빼기");
                if(line[1].equals("1")){
                    int del = maxQ.poll();
                    //maxQ.poll();
                    System.out.println(del);
                    minQ.remove(del);
                }
                else{
                    int del = minQ.poll();
                    //minQ.poll();
                    maxQ.remove(del);
                }
            }
        }
        if(maxQ.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        
        
        
        return answer;
    }
}
