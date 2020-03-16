
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
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
import java.util.*;

class Solution {
    class Pair implements Comparable<Pair>{
        int request, duration;
        public Pair(int request, int duration){
            this.request = request;
            this.duration = duration;
        }

        @Override
        public int compareTo(Pair that) {
            if(this.duration < that.duration)
                return -1;
            else if(this.duration == that.duration)
                return 0;
            else
                return 1;
        }
    }
    class Job implements Comparable<Job>{
        int request, duration;
        public Job(int request, int duration){
            this.request = request;
            this.duration = duration;
        }

        @Override
        public int compareTo(Job that) {
            if(this.request < that.request)
                return -1;
            else if(this.request == that.request)
                return 0;
            else
                return 1;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int done = 0;
        int jobNum = jobs.length;

        Job[] arrayJobs = new Job[jobNum];
        for(int i = 0; i < jobNum; i++){
            arrayJobs[i] = new Job(jobs[i][0], jobs[i][1]);
        }
        Arrays.sort(arrayJobs);

        PriorityQueue<Pair> queue = new PriorityQueue<>();

        int idx = 0;

        while(done < jobNum){
            while(idx < jobNum && arrayJobs[idx].request <= time)
                queue.add(new Pair(arrayJobs[idx].request, arrayJobs[idx++].duration));
            if(queue.isEmpty()){
                time++;
                continue;
            }
            Pair now = queue.poll();
            time += now.duration;
            done++;
            answer += (time - now.request);
        }


        return answer / jobNum;
    }
}
