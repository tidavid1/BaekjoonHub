import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i=0;i<arr.length;){
            if(answer.isEmpty()){
                answer.add(arr[i++]);
            }else{
                if(answer.get(answer.size()-1) == arr[i]){
                    answer.remove(answer.size()-1);
                    i++;
                }else{
                    answer.add(arr[i++]);
                }
            }
        }
        if(answer.isEmpty()){
            answer.add(-1);
        }
        return answer;
    }
}