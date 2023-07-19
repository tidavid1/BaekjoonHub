import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int sum = 0;
        for(int truck_weight:truck_weights){
            while (true){
                if(queue.size() == bridge_length){
                    sum -= queue.poll();
                }else{
                    if(queue.isEmpty() || sum+truck_weight <= weight){
                        queue.add(truck_weight);
                        sum += truck_weight;
                        time += 1;
                        break;
                    }else{
                        queue.add(0);
                        time += 1;
                    }
                }
            }
        }
        return time+bridge_length;
    }
}