import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> table = new HashMap<>();
        ArrayList<Character> temp = new ArrayList<>();
        for(char c: s.toCharArray()){
            table.put(c, table.get(c) == null? 1 : table.get(c)+1);
        }
        for(char c: table.keySet()){
            if(table.get(c) == 1) temp.add(c);
        }
        Collections.sort(temp);
        for(char c:temp){
            sb.append(c);
        }
        return sb.toString();
    }
}