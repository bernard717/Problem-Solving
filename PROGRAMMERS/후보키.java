import java.util.HashSet;

class Solution {
    public int solution(String[][] relation) {
        int rowLen = relation.length;
        int colLen = relation[0].length;

        HashSet<String> selects = new HashSet<>();
        HashSet<Integer> candidates = new HashSet<>();
        
        // 원소 수가 colLen개인 집합의 부분 집합에 대해 for문
        for(int bit = 1; bit < (1 << colLen); bit++){
            selects.clear();
            for(int row = 0; row < rowLen; row++){
                String data = "";
                for(int col = 0; col < colLen; col++){
                    // 부분집합이 해당 column을 포함하는 지 확인
                    if((bit & (1 << col)) != 0)
                        data += relation[row][col] + ",";
                }
                selects.add(data);
            }
            if(selects.size() == rowLen)
                push(candidates, bit);
        }
        return candidates.size();
    }
    public void push(HashSet<Integer> candidates, int bit){
        for(int key : candidates){
            // 기존에 있는 key와 새로 들어올 bit의 교집합이 key이면, 최소성 원칙 위배
            if((key & bit) == key){
                return;
            }
        }
        candidates.add(bit);
    }
}
