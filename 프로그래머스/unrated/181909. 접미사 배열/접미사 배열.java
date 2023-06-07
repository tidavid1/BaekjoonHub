import java.util.*;
class Solution {
    public ArrayList<String> solution(String my_string) {
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0;i<my_string.length();i++){
            answer.add(my_string.substring(i));
        }
        Collections.sort(answer);
        return answer;
    }
}