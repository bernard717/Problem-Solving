import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0; i < num; i++){
            String[] lines = br.readLine().split(" ");
            // 각 문자마다 해당하는 배열의 숫자 증가시킴
            for(int j = 0; j < lines[0].length(); j++){
                arr1[lines[0].charAt(j) - 'a']++;
            }
            for(int j = 0; j < lines[1].length(); j++){
                arr2[lines[1].charAt(j) - 'a']++;
            }
            boolean flag = false;
            // 앞 문자열과 뒷 문자열에서 생성한 배열의 동일 여부 체크
            for(int j = 0; j < 26; j++){
                if(arr1[j] != arr2[j]){
                    flag = true;
                    break;
                }
            }
            if(flag)
                System.out.println("Impossible");
            else
                System.out.println("Possible");
            arr1 = new int[26];
            arr2 = new int[26];
        }
    }
}
