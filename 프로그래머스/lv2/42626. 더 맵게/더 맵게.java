import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i:scoville){
            queue.add(i);
        }
        while(queue.peek() < K){
            if(queue.size() == 1){
                answer = -1;
                break;
            }
            int k1 = queue.poll();
            int k2 = queue.poll();
            queue.add(k1+k2*2);
            answer += 1;
        }
        return answer;
    }
}