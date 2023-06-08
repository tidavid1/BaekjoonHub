import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i:arr) answer.add(i);
        for(int i:delete_list){
            if(answer.contains(i)) answer.remove(Integer.valueOf(i));
        }
        return answer;
    }
}