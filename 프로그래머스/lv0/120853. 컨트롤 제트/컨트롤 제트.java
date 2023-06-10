import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        for(String str: s.split(" ")){
            if(str.equals("Z")){
                temp.remove(temp.size()-1);
            }else{
                temp.add(Integer.valueOf(str));
            }
        }
        for(int i: temp){
            answer +=i;
        }
        return answer;
    }
}