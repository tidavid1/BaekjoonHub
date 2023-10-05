import java.util.Arrays;
class Solution {
    public int[] solution(int n, int s) {
        int quotient = s / n;
        int remainder = s % n;
        if (quotient == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int idx = answer.length - 1;
        Arrays.fill(answer, quotient);
        for (int i = 0; i < remainder; i++) {
            answer[idx--] += 1;
        }
        return answer;
    }
}