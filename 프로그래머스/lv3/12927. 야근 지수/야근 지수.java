import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Arrays.stream(works).forEach(queue::add);
        while (n > 0 && !queue.isEmpty()) {
            queue.add(queue.poll() - 1);
            n -= 1;
        }
        answer = Arrays.stream(queue.stream().filter(integer -> integer > 0).toArray()).mapToLong(i -> (long) Math.pow((int)i, 2)).sum();
        return answer;
    }
}