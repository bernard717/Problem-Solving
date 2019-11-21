import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int sizeA = Integer.parseInt(line[0]);
        int sizeB = Integer.parseInt(line[1]);
        int[] a = new int[sizeA];
        int[] b = new int[sizeB];
        String[] lineA = br.readLine().split(" ");
        for(int i = 0; i < sizeA; i++)
            a[i] = Integer.parseInt(lineA[i]);
        String[] lineB = br.readLine().split(" ");
        for(int i = 0; i < sizeB; i++)
            b[i] = Integer.parseInt(lineB[i]);
        int i = 0;
        int j = 0;
        int start = 0;
        int mid = sizeA - 1;
        int end = sizeB - 1;
        int[] c = new int[sizeA + sizeB];
        int k = 0;
        while(i <= mid && j <= end){
            if(a[i] > b[j])
                c[k++] = b[j++];
            else
                c[k++] = a[i++];
        }
        while(i <= mid)
            c[k++] = a[i++];
        while(j <= end)
            c[k++] = b[j++];
        StringBuilder sb = new StringBuilder();
        for(int m = 0; m < sizeA+sizeB; m++)
            sb.append(c[m] + " ");
        System.out.println(sb);

    }
}
