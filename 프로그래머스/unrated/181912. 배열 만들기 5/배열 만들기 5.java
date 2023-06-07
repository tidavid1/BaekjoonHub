import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(String str:intStrs){
            int temp = Integer.valueOf(str.substring(s,s+l));
            if(temp > k){
                answer.add(temp);
            }
        }
        return answer;
    }
}