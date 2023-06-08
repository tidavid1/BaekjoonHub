import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String myString) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(String s: myString.split("x")){
            answer.add(s.length());
        }
        if(myString.endsWith("x")){
            answer.add(0);
        }
        return answer;
    }
}