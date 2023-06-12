import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> table = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<name.length;i++){
            table.put(name[i], yearning[i]);
        }
        for(String[] p:photo){
            int temp = 0;
            for(String s: p){
                temp += table.get(s) != null ? table.get(s) : 0;
            }
            answer.add(temp);
        }
        return answer;
    }
}