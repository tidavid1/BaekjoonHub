import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer ="";
        Map<String ,Integer> table = new HashMap<>();
        for(String s: completion){
            table.put(s, table.getOrDefault(s, 0)+1);
        }
        for(String s: participant){
            if(table.getOrDefault(s, 0) == 0){
                answer = s;
                break;
            }
            table.put(s, table.get(s)-1);
        }
        return answer;
    }
}