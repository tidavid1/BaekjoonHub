import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> table = new HashMap<>();
        for(String[] cloth:clothes){
            table.put(cloth[1], table.getOrDefault(cloth[1], 0)+1);
        }
        for(String s: table.keySet()){
            answer *= table.get(s)+1;
        }
        return answer -1;
    }
}