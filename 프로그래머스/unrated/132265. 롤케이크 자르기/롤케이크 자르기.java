import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:topping){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(int i:topping){
            set.add(i);
            map.put(i, map.get(i)-1);
            if(map.get(i) == 0){
                map.remove(i);
            }
            if(set.size() == map.size()){
                answer += 1;
            }
        }
        
        
        return answer;
    }
}