import java.util.*;
class Solution {
    
    public int solution(int[] q1, int[] q2) {
        int answer = 0;
        long sumQueue1 = 0;
        long sumQueue2 = 0;
        int maxMove = (q1.length + q2.length)*2;
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for (int i : q1) {
            queue1.add(i);
            sumQueue1 += i;
        }
        for (int i : q2) {
            queue2.add(i);
            sumQueue2 += i;
        }
        if ((sumQueue1 + sumQueue2) % 2 == 1) {
            return -1;
        }
        for (int i : queue1) {
            if (i > (sumQueue1 + sumQueue2) / 2) {
                return -1;
            }
        }
        for (int i : queue2) {
            if (i > (sumQueue1 + sumQueue2) / 2) {
                return -1;
            }
        }
        do {
            int value;
            if (sumQueue1 > sumQueue2) {
                value = queue1.poll();
                queue2.add(value);
                sumQueue1 -= value;
                sumQueue2 += value;
                answer += 1;
            } else if (sumQueue1 < sumQueue2) {
                value = queue2.poll();
                queue1.add(value);
                sumQueue1 += value;
                sumQueue2 -= value;
                answer += 1;
            }
            if(answer > maxMove){
                return -1;
            }
        } while (sumQueue1 != sumQueue2);
        return answer;
    }
}