import java.util.*;

class Solution {

    private char[][] table;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, -1, 0, 1};

    public int[] solution(String[] maps) {
        List<Integer> result = new ArrayList<>();
        table = new char[maps.length][];
        for (int i = 0; i < table.length; i++) {
            table[i] = maps[i].toCharArray();
        }
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] != 'X') {
                    result.add(dfs(i, j));
                }
            }
        }
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        if (answer.length == 0) {
            answer = new int[]{-1};
        }
        return answer;
    }


    private int dfs(int x, int y) {
        int value = table[x][y] - '0';
        table[x][y] = 'X';
        for (int i = 0; i < dx.length; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];
            if (moveX >= 0 && moveX < table.length && moveY >= 0 && moveY < table[moveX].length
                && table[moveX][moveY] != 'X') {
                value += dfs(moveX, moveY);
            }
        }
        return value;
    }
}