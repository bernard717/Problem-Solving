import java.io.*;
import java.util.*;

class Member implements Comparable<Member> {
    int korean;
    int english;
    int math;
    String name;
    Member(int korean, int english, int math, String name){
        this.korean = korean;
        this.english = english;
        this.math = math;
        this.name = name;
    }
    public int compareTo(Member that){
        if (this.korean < that.korean)
            return 1;
        else if(this.korean == that.korean){
            if(this.english < that.english)
                return -1;
            else if(this.english == that.english){
                if(this.math < that.math)
                    return 1;
                else if(this.math == that.math){
                    return this.name.compareTo(that.name);
                }
                else
                    return -1;
            }
            else
                return 1;
        }
        else
            return -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Member[] array = new Member[n];
        int order = 0;
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            String name = line[0];
            int korean = Integer.parseInt(line[1]);
            int english = Integer.parseInt(line[2]);
            int math = Integer.parseInt(line[3]);
            array[i] = new Member(korean, english, math, name);
        }
        Arrays.sort(array, new Comparator<Member>() {
            public int compare(Member m1, Member m2){
                return m1.compareTo(m2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Member m : array){
            sb.append(m.name + "\n");
        }
        System.out.println(sb);
    }
}
