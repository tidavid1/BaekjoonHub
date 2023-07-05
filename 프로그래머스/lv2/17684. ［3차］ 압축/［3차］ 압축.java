import java.util.*;
class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        int idx = 1;
        for(String s:"ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")){
            dict.put(s, idx++);
        }
        for(int i=0;i<msg.length();){
            int j = 1;
            while(dict.containsKey(msg.substring(i, i+j))){
                j++;
                if(i+j > msg.length())
                    break;
            }
            answer.add(dict.get(msg.substring(i,i+j-1)));
            if(i+j > msg.length()){
                i+=j;
                continue;
            }
            dict.put(msg.substring(i,i+j), idx++);
            i+=j-1;
        }
        return answer;
    }
}