import java.util.Arrays;
class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        my_string = my_string.toLowerCase();
        char[] temp = my_string.toCharArray();
        Arrays.sort(temp);
        for(char c: temp){
            sb.append(c);
        }
        return sb.toString();
    }
}