import java.util.*;
class Solution {
    public ArrayList<String> solution(String[] quiz) {
        ArrayList<String> answer = new ArrayList<>();
        for(String s:quiz){
            String[] temp = s.split(" ");
            if(temp[1].equals("-")){
                answer.add(Integer.valueOf(temp[0]) - Integer.valueOf(temp[2]) == Integer.valueOf(temp[4])? "O":"X");
            }else{
                answer.add(Integer.valueOf(temp[0]) + Integer.valueOf(temp[2]) == Integer.valueOf(temp[4])? "O":"X");
            }
        }
        return answer;
    }
}