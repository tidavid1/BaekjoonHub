import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int count = 0;
        Queue<Integer> queueA = new PriorityQueue<>();
        Queue<Integer> queueB = new PriorityQueue<>();
        for (int i : A) {
            queueA.add(i);
        }
        for (int i : B) {
            queueB.add(i);
        }
        while (!queueB.isEmpty()) {
            int b = queueB.poll();
            if (queueA.peek() < b) {
                queueA.poll();
                count += 1;
            }
        }
        return count;
    }
}