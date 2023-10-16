import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int count = 0;
        Arrays.sort(routes, (route1, route2) -> {
            if (route1[0] == route2[0]) {
                return route1[1] - route2[1];
            }
            return route1[0] - route2[0];
        });
        int min = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (route[0] > min) {
                min = route[1];
                count += 1;
                continue;
            }
            if (route[1] < min) {
                min = route[1];
            }
        }
        return count;
    }
}