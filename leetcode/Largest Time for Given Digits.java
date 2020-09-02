class Solution {
    public class Pair implements Comparable<Pair>{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair that){
            if(this.x < that.x)
                return 1;
            else if(this.x == that.x){
                if(this.y < that.y)
                    return 1;
                else
                    return -1;
            }
            else
                return -1;
        }
    }
    public static boolean next(int[] a){
        int i = a.length - 1;
        while(i > 0 && a[i] <= a[i - 1])
            i--;
        if(i <= 0)
            return false;
        int j = a.length - 1;
        while(a[j] <= a[i - 1])
            j--;
        int temp = a[j];
        a[j] = a[i - 1];
        a[i - 1] = temp;
        j = a.length - 1;
        while(j > i){
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            j--;
            i++;
        }
        return true;
    }

    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        do{
            Pair p = new Pair(makeNum(A[0], A[1]), makeNum(A[2], A[3]));
            pq.add(p);
        }while(next(A));
        while(!pq.isEmpty()){
            Pair now = pq.remove();
            if(now.x <= 23 && now.y <= 59)
                return makeString(now.x) + ":" + makeString(now.y);
        }
        return "";
    }
    public int makeNum(int a, int b){
        return 10 * a + b;
    }
    public String makeString(int num){
        if(num < 10)
            return "0" + Integer.toString(num);
        else
            return Integer.toString(num);
    }
}
