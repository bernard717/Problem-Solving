import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap();

        int len = clothes.length;

        for(int i = 0; i < len; i++){
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(Integer i : hashMap.values()){
            answer *= (i + 1);
        }




        return answer - 1;
    }
}
