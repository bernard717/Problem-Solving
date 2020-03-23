import java.util.ArrayList;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        int keyLen = key.length;
        int lockLen = lock.length;

        int[][] board = new int[3 * lockLen][3 * lockLen];
        for(int i = 0;  i < board.length; i++){
            for(int j = 0; j < board.length; j++)
                board[i][j] = -1;
        }
        int sum = 0;
        for(int i = 0; i < lockLen; i++) {
            for(int j = 0; j < lockLen; j++) {
                if(lock[i][j] == 0) sum++;
                board[keyLen - 1 + i][keyLen - 1 + j] = lock[i][j];
            }
        }
        // key 배열을 각각 90, 180, 270도 회전한 배열들 
        int[][] key1 = rotate(key);
        int[][] key2 = rotate(key1);
        int[][] key3 = rotate(key2);

        ArrayList<int[][]> arrayList = new ArrayList<>();
        arrayList.add(key);
        arrayList.add(key1);
        arrayList.add(key2);
        arrayList.add(key3);
        
        // key 배열이 lock 주위를 모두 거치면서 조건에 맞는 경우가 있는 지 완전탐색
        for(int i = 0; i <= keyLen + lockLen - 2; i++){
            for(int j = 0; j <= keyLen + lockLen - 2; j++){
                int[] temp = {0, 0, 0, 0};
                for(int m = 0; m < keyLen; m++){
                    for(int n = 0; n < keyLen; n++){
                        if (board[i + m][j + n] == -1) continue;

                        for(int k = 0; k < 4; k++){
                            int[][] tempArr = arrayList.get(k);
                            if (tempArr[m][n] == 1 && board[i + m][j + n] == 1) {
                                temp[k] = -1;
                                continue;
                            }
                            if (tempArr[m][n] == 1 && board[i + m][j + n] == 0) temp[k]++;
                        }
                    }
                }
                for(int k = 0; k < 4; k++){
                    if(temp[k] == sum)
                        return true;
                }
            }
        }
        return answer;
    }
    
    // 배열 90도 회전
    public int[][] rotate(int[][] key){
        int[][] rotated = new int[key.length][key.length];
        for(int i = 0; i < key.length; i++){
            for(int j = key.length - 1; j >= 0; j--){
                rotated[i][key.length - j - 1] = key[j][i];
            }
        }
        return rotated;
    }
}
