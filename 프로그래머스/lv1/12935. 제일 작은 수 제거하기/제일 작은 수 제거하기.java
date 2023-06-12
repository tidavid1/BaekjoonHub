import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int min = Arrays.stream(arr).min().getAsInt();
        if(arr.length == 1){
            answer.add(-1);
        }else{
            for(int i=0;i<arr.length;i++){
                if(arr[i] == min) continue;
                answer.add(arr[i]);
            }
        }
        return answer;
    }
}