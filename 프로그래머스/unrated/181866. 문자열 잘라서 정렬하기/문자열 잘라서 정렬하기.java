import java.util.Arrays;
class Solution {
    public String[] solution(String myString) {
        myString = myString.replaceAll("x+", "x");
        myString = myString.replaceAll("^x", "");
        String[] answer = myString.split("x");
        Arrays.sort(answer);
        return answer;
    }
}