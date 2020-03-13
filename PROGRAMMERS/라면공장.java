
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
import java.util.*;

class Solution {
    class Pair implements Comparable<Pair>{
        int idx, supply;
        public Pair(int idx, int supply){
            this.idx = idx;
            this.supply = supply;
        }

        @Override
        public int compareTo(Pair that) {
            if(this.supply < that.supply)
                return 1;
            else if(this.supply == that.supply)
                return 0;
            else
                return -1;
        }
    }
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>();

        boolean[] visited  = new boolean[dates.length];

        int start = stock;
        int idx = 0;

        while(start < k){
            while(idx < dates.length && dates[idx] <= start && !visited[idx]){
                queue.add(new Pair(idx, supplies[idx++]));
            }
            Pair p =  queue.poll();
            start += p.supply;
            visited[p.idx] = true;
            answer++;
        }

        return answer;
    }
}
