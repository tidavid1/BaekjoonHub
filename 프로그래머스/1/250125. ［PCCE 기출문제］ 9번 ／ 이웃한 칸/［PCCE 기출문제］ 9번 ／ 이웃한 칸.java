class Solution {

    private final int[] dy = {0, 1, -1, 0};
    private final int[] dx = {1, 0, 0, -1};

    public int solution(String[][] board, int h, int w) {
        var count = 0;
        var n = board.length;
        var color = board[h][w];
        for (int i = 0; i < 4; i++) {
            int x = h + dy[i];
            int y = w + dx[i];
            if (x >= 0 && x < n && y >= 0 && y < n && color.equals(board[x][y])) {
                count += 1;
            }
        }
        return count;
    }
}