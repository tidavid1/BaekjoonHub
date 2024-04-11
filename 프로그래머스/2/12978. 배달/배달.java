import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.solution(5, new int[][]{{1, 2, 4}, {1, 3, 1}, {3, 4, 1}, {4, 2, 1}, {2, 5, 1}}, 4));
    }

    private final Queue<Integer> queue = new LinkedList<>();
    private int[][] arrays;
    private int[] results;

    public int solution(int n, int[][] roads, int k) {
        arrays = new int[n + 1][n + 1];
        results = new int[n + 1];
        int result = 0;
        Arrays.fill(results, Integer.MAX_VALUE);
        for (int[] arr : arrays) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        for (int[] road : roads) {
            arrays[road[0]][road[1]] = Math.min(arrays[road[0]][road[1]], road[2]);
            arrays[road[1]][road[0]] = Math.min(arrays[road[1]][road[0]], road[2]);
        }
        results[1] = 0;
        queue.add(1);
        while (!queue.isEmpty()) {
            bfs();
        }
        for (int i : results) {
            result += i <= k ? 1 : 0;
        }
        return result;
    }

    private void bfs() {
        var size = queue.size();
        while (size-- > 0) {
            var value = queue.poll();
            for (int i = 1; i < arrays[value].length; i++) {
                if (arrays[value][i] != Integer.MAX_VALUE) {
                    int length = results[value] + arrays[value][i];
                    if (results[i] > length) {
                        results[i] = length;
                        queue.add(i);
                    }
                }
            }
        }
    }
}