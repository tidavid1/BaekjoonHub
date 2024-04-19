import java.util.*;

class Solution {

    private int[] arr;
    
    public int solution(int n, int[][] costs) {
        int result = 0;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        for (int[] cost : costs) {
            if (validateCycle(cost)) {
                continue;
            }
            union(cost[0], cost[1]);
            result += cost[2];
        }
        return result;
    }

    private boolean validateCycle(int[] cost) {
        int start = cost[0];
        int end = cost[1];
        return findRoot(start) == findRoot(end);
    }

    private int findRoot(int n) {
        arr[n] = arr[n] == n ? n : findRoot(arr[n]);
        return arr[n];
    }

    private void union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);
        if (a != b) {
            arr[b] = a;
        }
    }
}