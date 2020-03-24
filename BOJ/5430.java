import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int i = 0; i < test; i++){
            String s = br.readLine();
            int num = Integer.parseInt(br.readLine());
            String elements = br.readLine();
            String[] temp = elements.substring(1, elements.length() - 1).split(",");
            int[] arr = new int[num];
            for(int j = 0; j < num; j++)
                arr[j] = Integer.parseInt(temp[j]);

            int start = 0;
            int end = num - 1;
            int size = num;
            boolean flag = false;

            for(int j = 0; j < s.length(); j++){
                char func = s.charAt(j);
                if(func == 'R'){
                    int tempNum = start;
                    start = end;
                    end = tempNum;
                }
                else{
                    if(size == 0){
                        System.out.println("error");
                        flag = true;
                        break;
                    }
                    if(start < end)
                        start++;
                    else
                        start--;
                    size--;
                }
            }
            if(size != 0){
                StringBuilder sb = new StringBuilder();
                sb.append("[").append(arr[start]);
                if(start < end) {
                    for (int j = start + 1; j <= end; j++)
                        sb.append(",").append(arr[j]);
                }
                else{
                    for(int j = start - 1; j >= end; j--)
                        sb.append(",").append(arr[j]);
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
            else{
                if(!flag)
                    System.out.println("[]");
            }
        }
    }
}
