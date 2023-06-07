import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int min = -1;int max = -1;
        for(int i=0;i<arr.length;i++){
            if (arr[i] == 2){
                min = min == -1 ? i : min;
                max = i;
            }
        }
        if(min == -1){
            answer.add(min);
            return answer;
        }
        for(;min<=max;min++){
            answer.add(arr[min]);
        }
        return answer;
    }
}