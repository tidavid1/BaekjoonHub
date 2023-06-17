import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<score.length;i++){
            queue.add(score[i]);
            if(queue.size()<=k){
                answer[i] = queue.peek();
            }else{
                queue.poll();
                answer[i] = queue.peek();
            }
        }
        return answer;
    }
}