import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int l, int r) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=l;i<=r;i++){
            boolean flag = true;
            String s = Integer.toString(i);
            for(int j = 0; j < s.length();j++){
                char c = s.charAt(j);
                if(c != '0' && c!='5'){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer.add(i);
            }
        }
        if(answer.size() == 0){
            answer.add(-1);
        }
        return answer;
    }
}