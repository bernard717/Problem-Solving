import java.io.*;
import java.util.*;

class Member implements Comparable<Member> {
    int age;
    int order;
    String name;
    Member(int age, int order, String name){
        this.age = age;
        this.order = order;
        this.name = name;
    }
    public int compareTo(Member that){
        if (this.age < that.age)
            return -1;
        else if(this.age == that.age){
            if(this.order < that.order)
                return -1;
            else
                return 1;
        }
        else
            return 1;
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
            int age = Integer.parseInt(line[0]);
            String name = line[1];
            array[i] = new Member(age, order++, name);
        }
        Arrays.sort(array, new Comparator<Member>() {
            public int compare(Member m1, Member m2){
                return m1.compareTo(m2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Member m : array){
            sb.append(m.age + " " + m.name + "\n");
        }
        System.out.println(sb);
    }
}
