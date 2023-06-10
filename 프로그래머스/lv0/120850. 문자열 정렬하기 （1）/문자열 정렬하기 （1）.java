import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String my_string) {
        ArrayList<Integer> answer = new ArrayList<>();
        my_string = my_string.replaceAll("[a-z]", "");
        char[] temp = my_string.toCharArray();
        Arrays.sort(temp);
        for(char c: temp){
            answer.add(c-'0');
        }
        return answer;
    }
}