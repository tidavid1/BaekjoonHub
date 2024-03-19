class Solution {
    public int solution(int n) {
        int answer = 0;
        while (n > 0) {
            int remain = n % 10;
            n /= 10;
            if (remain > 5) {
                answer += 10 - remain;
                n += 1;
            } else {
                answer += remain;
            }
            if (remain == 5) {
                int temp = n % 10;
                if (temp >= 5) {
                    n += 1;
                }
            }
            
        }
        return answer;
    }
}