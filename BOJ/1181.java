import java.io.*;
import java.util.*;
public class Main {
    static class Word implements Comparable<Word>{
        int len;
        String name;
        Word(int len, String name){
            this.len = len;
            this.name = name;
        }
        public int compareTo(Word that){
            if(this.len < that.len)
                return -1;
            else if(this.len == that.len)
                return this.name.compareTo(that.name);
            else
                return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Word[] a =  new Word[n];
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            a[i] = new Word(line.length(), line);
        }
        Arrays.sort(a);
        StringBuilder sb =  new StringBuilder();
        String temp = a[0].name;
        bw.write(a[0].name + "\n");
        for(int i = 0; i < n; i++){
            if(temp.equals(a[i].name))
                continue; 
            else {
                bw.write(a[i].name + "\n");
                temp = a[i].name;
            }
        }
        bw.close();
    }
}
