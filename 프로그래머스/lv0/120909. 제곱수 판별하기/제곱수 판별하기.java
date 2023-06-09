class Solution {
    public int solution(int n) {
        return n % (int)Math.sqrt(n) == 0 ? 1 : 2;
    }
}