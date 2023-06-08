import java.util.*;
class Solution {
    public ArrayList<String> solution(String[] picture, int k) {
        ArrayList<String> answer = new ArrayList<>();
        for(String s: picture){
            for(int i=0;i<k;i++){
                StringBuilder sb = new StringBuilder();
                for(char c:s.toCharArray()){
                    for(int j=0;j<k;j++){
                        sb.append(c);
                    }
                }
                answer.add(sb.toString());
            }
        }
        return answer;
    }
}