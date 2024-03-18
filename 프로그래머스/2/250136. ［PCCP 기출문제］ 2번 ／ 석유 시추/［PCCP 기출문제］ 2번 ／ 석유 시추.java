import java.util.*;

class Solution {
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    private int[][] board;
    private static final Queue<int[]> QUEUE = new LinkedList<>();
    private static final Map<Integer, Integer> MAP = new HashMap<>();

    public int solution(int[][] land) {
        int flag = 'A';
        board = land;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    QUEUE.add(new int[]{i, j});
                    int result = bfs(flag);
                    MAP.put(flag++, result);
                }
            }
        }
        int max = 0;
        for (int j = 0; j < board[0].length; j++) {
            Set<Integer> set = new HashSet<>();
            for (int[] arr : board) {
                if (arr[j] != 0) {
                    set.add(arr[j]);
                }
            }
            int temp = 0;
            for (int value : set) {
                temp += MAP.get(value);
            }
            max = Math.max(temp, max);
        }
        return max;
    }

    private int bfs(int flag) {
        int result = 0;
        while (!QUEUE.isEmpty()) {
            int size = QUEUE.size();
            while (size-- > 0) {
                int[] location = QUEUE.poll();
                int x = location[0];
                int y = location[1];
                if (board[x][y] != 1) {
                    continue;
                }
                board[x][y] = flag;
                result += 1;
                for (int i = 0; i < DX.length; i++) {
                    int dx = x + DX[i];
                    int dy = y + DY[i];
                    if (dx >= 0 && dx < board.length && dy >= 0 && dy < board[dx].length
                        && board[dx][dy] == 1) {
                        QUEUE.add(new int[]{dx, dy});
                    }
                }
            }
        }
        return result;
    }
}