import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if(n%2 == 1 || m%2 == 1){
            for(int i = 0; i < n; i++)
                br.readLine();
            for(int i = 0; i < n; i++){
                if(i % 2 == 0) {
                    for (int j = 1; j < m; j++)
                        sb.append("R");
                }
                else{
                    for (int j = 1; j < m; j++)
                        sb.append("L");
                }
                if(i != n - 1)
                    sb.append("D");
            }
            System.out.println(sb);
        }
        else{
            int[][] a = new int[n][m];
            int minX = 0;
            int minY = 0;
            int min = 1000;
            for(int i = 0; i < n; i++){
                String[] temp = br.readLine().split(" ");
                for(int j = 0;  j < m; j++){
                    a[i][j] = Integer.parseInt(temp[j]);
                    if(min > a[i][j] && (i > 0 || j > 0) && (i < n - 1 || j < n - 1) && ((i + j)%2 == 1)){
                        min = a[i][j];
                        minX = i;
                        minY = j;
                    }
                }
            }
            int nowA = 0;
            int nowB = n - 1;
            int afterA = 0;
            int afterB = m - 1;
            while(minX - nowA > 1){
                nowA += 2;
                for(int i = 1; i < m; i++)
                    sb.append("R");
                sb.append("D");
                for(int i = 1; i < m; i++)
                    sb.append("L");
                sb.append("D");
            }
            while(nowB - minX> 1){
                nowB -= 2;
                sb2.append("D");
                for(int i = 1; i < m; i++)
                    sb2.append("L");
                sb2.append("D");
                for(int i = 1; i < m; i++)
                    sb2.append("R");
            }
            while(minY - afterA > 1){
                afterA += 2;
                sb.append("DRUR");
            }
            while(afterB - minY > 1){
                afterB -= 2;
                StringBuilder temp = new StringBuilder();
                temp.append("RURD");
                sb2 = temp.append(sb2);
            }
            if(afterA == minY)
                sb.append("RD");
            else if(afterB == minY)
                sb.append("DR");
            sb = sb.append(sb2);
            System.out.println(sb);



        }
    }
}
