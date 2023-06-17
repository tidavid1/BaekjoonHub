import java.util.*;
class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> table = new HashMap<>();
        int[] answer = new int[s.length()];
        for(int i=0;i<s.length();i++){
            answer[i] = table.get(s.charAt(i)) == null?-1:i-(table.get(s.charAt(i)));
            table.put(s.charAt(i), i);
        }
        return answer;
    }
}