import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr, int divisor) {
        arr = Arrays.stream(arr).sorted().toArray();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i:arr){
            if(i%divisor == 0) answer.add(i);
        }
        if(answer.isEmpty()){
            answer.add(-1);
        }
        return answer;
    }
}