class Solution {
    public int solution(int n) {
        int count = Integer.toBinaryString(n).length()-Integer.toBinaryString(n).replace("1", "").length();
        do {
            n += 1;
        } while (Integer.toBinaryString(n).length() - Integer.toBinaryString(n).replace("1", "").length() != count);
        return n;
    }
}