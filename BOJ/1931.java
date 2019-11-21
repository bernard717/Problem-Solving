import java.io.*;
import java.util.*;

public class Main {
    static class Meeting implements Comparable<Meeting>{
        int begin, end;
        Meeting(int begin, int end){
            this.begin = begin;
            this.end = end;
        }
        public int compareTo(Meeting that){
            if(this.end < that.end)
                return -1;
            else if(this.end == that.end){
                if(this.begin < that.begin)
                    return -1;
                else
                    return 1;
            }
            else
                return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Meeting[] a = new Meeting[n];
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            a[i] = new Meeting(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        Arrays.sort(a);
        int temp = a[0].end;
        int sum = 1;
        for(int i = 1; i < n; i++){
            if(a[i].begin >= temp){
                sum++;
                temp = a[i].end;
            }
        }
        System.out.println(sum);
    }
}
