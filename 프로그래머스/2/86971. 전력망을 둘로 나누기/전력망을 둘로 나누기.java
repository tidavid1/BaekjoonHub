import java.util.*;

class Solution {

    private int[][] table;
    private boolean[] visited;
    private Queue<Integer> queue;

    public int solution(int n, int[][] wires) {
        int result = n;
        table = new int[n + 1][n + 1];
        for (int[] wire : wires) {
            table[wire[0]][wire[1]] = 1;
            table[wire[1]][wire[0]] = 1;
        }
        for (int[] wire : wires) {
            int[] counts = new int[2];
            int idx = 0;
            queue = new LinkedList<>();
            visited = new boolean[n + 1];
            table[wire[0]][wire[1]] = 0;
            table[wire[1]][wire[0]] = 0;
            for (int i = 1; i <= n; i++) {
                int count = bfs(i);
                if (count != -1) {
                    counts[idx++] = count;
                }
            }
            table[wire[0]][wire[1]] = 1;
            table[wire[1]][wire[0]] = 1;
            result = Math.min(Math.abs(counts[0] - counts[1]), result);
        }
        return result;
    }

    private int bfs(int n) {
        int result = 0;
        if (visited[n]) {
            return -1;
        }
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int node = queue.poll();
                visited[node] = true;
                for (int i = 1; i < table[node].length; i++) {
                    if (table[node][i] == 1 && !visited[i]) {
                        queue.add(i);
                    }
                }
                result += 1;
            }
        }
        return result;
    }
}