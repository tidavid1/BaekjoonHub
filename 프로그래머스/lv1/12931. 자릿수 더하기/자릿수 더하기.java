import java.util.*;

public class Solution {
    public int solution(int n) {
        String temp = Integer.toString(n);
        int answer = 0;
        for(int i=0; i<temp.length();i++){
            answer += Integer.parseInt(temp.substring(i, i+1));
        }
        return answer;
    }
}