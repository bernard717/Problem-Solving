import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
       
        // O(2^N)에서 N이 20을 넘어서기 때문에 배열을 반으로 나눠 각 배열의 크기가 20이하가 되도록 함
        int len1 = n / 2;
        int len2 = n - len1;

        long[] arr1 = new long[len1];
        long[] arr2 = new long[len2];

        s = br.readLine().split(" ");
        for(int i = 0; i < len1; i++)
            arr1[i] = Integer.parseInt(s[i]);

        for(int i = 0; i < len2; i++)
            arr2[i] = Integer.parseInt(s[i + len1]);

        long answer = 0;

        ArrayList<Long> arrayList1 = new ArrayList<>();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        
        // 첫 배열에 대해 bitmask를 이용해 부분집합의 합이 m이 되는 경우 확인
        for(int i = 1; i < Math.pow(2, len1); i++){
            long sum = 0;
            for(int j = 0; j < len1; j++){
                if((i & (1 << j)) == (1 << j))
                    sum += arr1[len1 - 1 - j];
            }
            arrayList1.add(sum);
            if(sum == m)
                answer++;
        }
        
        // 두번째 배열에 대해 bitmask를 이용해 부분집합의 합이 m이 되는 경우 확인
        for(int i = 1; i < Math.pow(2, len2); i++){
            long sum = 0;
            for(int j = 0; j < len2; j++){
                if((i & (1 << j)) == (1 << j))
                    sum += arr2[len2 - 1 - j];
            }
            arrayList2.add(sum);
            if(sum == m)
                answer++;
        }

        int i = 0;
        int j = arrayList2.size() - 1;

        Collections.sort(arrayList1);
        Collections.sort(arrayList2);
        
        // 각 배열의 부분집합의 합들을 저장한 arraylist 2개에 대해 하나씩 원소를 뽑았을 때 합이 m이 되는 경우 확인
        // 두 배열 오름차순 정렬
        // 첫 번째 배열은 앞에서부터, 두 번째 배열은 뒤에서부터 확인함으로써 중복을 피할 수 있음
        while(i < arrayList1.size() && j >= 0){
            long sum = arrayList1.get(i) + arrayList2.get(j);
            if(sum > m)
                j--;
            else if(sum < m)
                i++;
            else {
                // 같은 값이 여러 번 나오는 경우는 곱셈한 값을 더해줌
                long mult1 = 0;
                long mult2 = 0;
                long judge1 = arrayList1.get(i);
                long judge2 = arrayList2.get(j);
                while(i < arrayList1.size() && arrayList1.get(i) == judge1) {
                    mult1++;
                    i++;
                }
                while(j >= 0 && arrayList2.get(j) == judge2) {
                    mult2++;
                    j--;
                }
                answer += mult1 * mult2;
            }
        }
        System.out.print(answer);
    }
}
