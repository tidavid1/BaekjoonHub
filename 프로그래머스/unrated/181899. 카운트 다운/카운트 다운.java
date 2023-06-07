import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int start, int end) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(;start>=end;start--){
            answer.add(start);
        }
        return answer;
    }
}