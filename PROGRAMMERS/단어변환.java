import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int len = begin.length();
        
        int n = words.length;
        int[] dist = new int[n + 1];
        for(int i = 0; i <= n; i++)
            dist[i] = -1;
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        
        while(!q.isEmpty()){
            int p = q.remove();
            if(p == n) dist[p] = 0;
            for(int i = 0; i < n; i++){
                if(dist[i] != -1) continue;
                int sum = 0;
                for(int j = 0; j < len; j++){
                    if(sum > 1) break;
                    if(p == n) {
                        if(begin.charAt(j) != words[i].charAt(j)) sum++;
                    }
                    else{
                        if(words[p].charAt(j) != words[i].charAt(j)) sum++;
                    }
                    
                }
                if(sum == 1){ 
                    dist[i] = dist[p] + 1;
                    q.add(i);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(target.equals(words[i]))
                answer = dist[i];
        }
        
        
        return answer;
    }
}
