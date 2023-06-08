import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i:arr){
            for(int j=0;j<i;j++){
                answer.add(i);
            }
        }
        return answer;
    }
}