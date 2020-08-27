class Solution {
    public class Pair implements Comparable<Pair>{
        int st, idx;
        public Pair(int st, int idx){
            this.st = st;
            this.idx = idx;
        }
        public int compareTo(Pair that){
            if(this.st < that.st)
                return -1;
            else
                return 1;
        }
    }
    public int[] findRightInterval(int[][] intervals) {
        // intervals가 null인 경우
        if(intervals == null)
            return null;
        
        int len = intervals.length;
        
        int[] ans = new int[len];
        for(int i = 0; i < len; i++)
            ans[i] = -1;
        
        // intervals의 원소가 하나인 경우
        if(intervals.length == 1)
            return ans;
        
        // 시작점과 index를 묶는 pair의 집합
        Pair[] pairs = new Pair[len];
        
        // 전체 배열의 시작점과 index를 pairs에 넣음
        int idx = 0;
        for(int[] arr : intervals){
            Pair now = new Pair(arr[0], idx);
            pairs[idx++] = now;
        }
        
        // pairs 정렬
        Arrays.sort(pairs);
        
        for(int i = 0; i < len; i++){
            int endpoint = intervals[i][1];
            
            int st = 0;
            int en = len;
            while(st < en){
                int mid = (st + en) / 2;
                if(pairs[mid].st < endpoint)
                    st = mid + 1;
                else if(pairs[mid].st == endpoint){
                    ans[i] = pairs[mid].idx;
                    break;
                }
                else{
                    ans[i] = pairs[mid].idx;
                    en = mid;
                }
            }
        }
        
        return ans;
    }
}
