import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr, int[][] queries) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int[] query:queries){
            int min = 1000001;
            for(int i=query[0];i<=query[1];i++){
                if (arr[i] > query[2] && arr[i] < min){
                    min = arr[i];
                }
            }
            if (min == 1000001){
                min = -1;
            }
            answer.add(min);
        }
        return answer;
    }
}