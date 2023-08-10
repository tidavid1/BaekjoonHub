import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] operations){
        int[] answer = new int[2];
        Queue<Integer> queue = new PriorityQueue<>();
        for(String operation:operations){
            if (operation.contains("I")){
                queue.add(Integer.valueOf(operation.split(" ")[1]));
            }else {
                if(queue.isEmpty()){
                    continue;
                }
                if(operation.equals("D 1")){
                    List<Integer> temp = new ArrayList<>(queue.stream().sorted().collect(Collectors.toList()));
                    temp.remove(temp.size()-1);
                    queue = new PriorityQueue<>(temp);
                }else{
                    queue.poll();
                }
            }
        }
        if (!queue.isEmpty()){
            answer[0] = queue.stream().max(Comparator.naturalOrder()).get();
            answer[1] = queue.poll();
        }
        return answer;
    }
}