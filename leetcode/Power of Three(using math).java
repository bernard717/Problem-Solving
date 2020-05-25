class Solution {
    public boolean isPowerOfThree(int n) {
        // 1162261467은 int범위 내에서 가장 큰 3의 제곱수
        return n > 0 && 1162261467 % n == 0;
    }
}
