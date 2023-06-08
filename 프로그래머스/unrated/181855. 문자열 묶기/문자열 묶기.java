import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        HashMap<Integer, Integer> table = new HashMap<>();
        for(String s: strArr){
            table.put(s.length(), table.get(s.length()) == null ? 1 : table.get(s.length())+1);
        }
        return table.values().stream().max(Integer::compareTo).get();
    }
}