import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap1 = new HashMap();
        HashMap<String, Integer> hashMap2 = new HashMap();

        for(String p : participant){
            if(hashMap1.containsKey(p)){
                hashMap1.put(p, hashMap1.get(p) + 1);
            }
            else
                hashMap1.put(p, 1);
        }

        for(String p : completion){
            if(hashMap2.containsKey(p)){
                hashMap2.put(p, hashMap2.get(p) + 1);
            }
            else
                hashMap2.put(p, 1);
        }

        for(String s : hashMap1.keySet()){
            if(!hashMap2.containsKey(s)) {
                answer = s;
                break;
            }
            else if(hashMap2.containsKey(s)){
                if(!hashMap1.get(s).equals(hashMap2.get(s))){
                    answer = s;
                    break;
                }
            }
        }



        return answer;
    }
}
