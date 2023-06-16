import java.util.*;
class Solution {
    public ArrayList<String> solution(String[] strings, int n) {
        Map<String, ArrayList<String>> table = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();
        for(String s: strings){
            ArrayList<String> list;
            if(table.containsKey(s.substring(n,n+1))){
                list = table.get(s.substring(n,n+1));
                list.add(s);
                list.sort(Comparator.naturalOrder());
            }else{
                list = new ArrayList<>();
                list.add(s);
            }
            table.put(s.substring(n,n+1), list);
        }
        for(Object k:table.keySet().stream().sorted(Comparator.naturalOrder()).toArray()){
            answer.addAll(table.get(k));
        }
        return answer;
    }
}