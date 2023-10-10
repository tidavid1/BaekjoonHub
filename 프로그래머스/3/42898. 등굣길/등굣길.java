class Solution {
    private final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] board = new int[m][n];
        for (int[] puddle : puddles) {
            board[puddle[0] - 1][puddle[1] - 1] = -1;
        }
        board[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    board[i][j] = board[i][j - 1] == -1 ? 0 : board[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    board[i][j] = board[i - 1][j] == -1 ? 0 : board[i - 1][j];
                    continue;
                }
                board[i][j] = ((board[i - 1][j] == -1 ? 0 : board[i - 1][j]) + (board[i][j - 1] == -1 ? 0 : board[i][j - 1])) % MOD;
            }
        }
        return board[m - 1][n - 1] % MOD;
    }
}