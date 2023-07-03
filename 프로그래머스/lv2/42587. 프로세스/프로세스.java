import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        for(int priority: priorities){
            queue.add(priority);
        }
        while(!queue.isEmpty()){
            int max = queue.stream().mapToInt(Integer::intValue).max().getAsInt();
            if(queue.peek() != max){
                queue.add(queue.poll());
                location = location == 0 ? queue.size()-1:location-1;
            }else{
                queue.poll();
                if(location == 0)
                    break;
                else
                    location -=1;
            }
        }
        return priorities.length-queue.size();
    }
}