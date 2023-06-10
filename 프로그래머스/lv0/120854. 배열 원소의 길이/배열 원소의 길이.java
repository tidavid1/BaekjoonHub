import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String[] strlist) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(String s:strlist){
            answer.add(s.length());
        }
        return answer;
    }
}