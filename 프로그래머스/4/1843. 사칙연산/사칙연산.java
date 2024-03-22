import java.util.*;

class Solution {

    int[] numbers;
    int[] words;
    int[][][] dp;

    public int solution(String[] arr) {
        int n = arr.length / 2;
        numbers = new int[n + 1];
        words = new int[n];
        dp = new int[n + 1][n + 1][];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                numbers[i / 2] = Integer.parseInt(arr[i]);
                continue;
            }
            words[i / 2] = arr[i].equals("+") ? 0 : 1;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == j) {
                    dp[i][j] = new int[]{numbers[i], numbers[i]};
                    continue;
                }
                dp[i][j] = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
            }
        }
        return calculate(0, n, 0);
    }

    private int calculate(int start, int end, int flag) {
        if (start == end || (dp[start][end][flag] != Integer.MAX_VALUE
            && dp[start][end][flag] != Integer.MIN_VALUE)) {
            return dp[start][end][flag];
        }
        int result = flag == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int sign = words[i];
            int n = calculate(start, i, flag);
            int m = calculate(i + 1, end, sign);
            int value = sign == 0 ? n + m : n - m;
            result = flag == 0 ? Math.max(result, value) : Math.min(result, value);
            dp[start][end][flag] = flag == 0 ? Math.max(dp[start][end][flag], value)
                : Math.min(dp[start][end][flag], value);
        }
        return dp[start][end][flag];
    }
}