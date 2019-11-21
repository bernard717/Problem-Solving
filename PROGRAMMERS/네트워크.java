import java.util.*;
import java.io.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isvisited = new boolean[n];
        for(int i = 0; i < n; i++){
            Queue<Integer> q = new LinkedList<Integer>();
            if(isvisited[i]) continue;
            answer++;
            q.add(i);
            isvisited[i] = true;
            while(!q.isEmpty()){
                int temp = q.remove();
                for(int j = 0; j < n; j++){
                    if(temp != j && !isvisited[j] && computers[temp][j] == 1){
                        isvisited[j] = true;
                        q.add(j);
                    }
                }
            }
        }
        return answer;
    }
}
