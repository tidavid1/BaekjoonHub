class Solution {
    public int[] solution(int[] sequence, int k) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == k) {
                return new int[]{i, i};
            }
        }
        int left = 0, right = sequence.length - 1;
        int sum = 0;
        for (int l = 0, r = 0; l < sequence.length; l++) {
            while (r < sequence.length && sum < k) {
                sum += sequence[r++];
            }
            if (sum == k) {
                int range = r - l - 1;
                if ((right - left) > range) {
                    left = l;
                    right = r - 1;
                }
            }
            sum -= sequence[l];
        }
        return new int[]{left, right};
    }
}