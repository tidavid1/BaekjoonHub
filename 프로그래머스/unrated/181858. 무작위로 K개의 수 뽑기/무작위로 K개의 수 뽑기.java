import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i:arr){
            if(answer.size()==k) break;
            if(!answer.contains(i)) answer.add(i);
        }
        while(answer.size()<k) answer.add(-1);
        return answer;
    }
}