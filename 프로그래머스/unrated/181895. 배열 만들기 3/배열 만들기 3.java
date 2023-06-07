import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int[] interval:intervals){
            for(int i=interval[0];i<=interval[1];i++) answer.add(arr[i]);
        }
        return answer;
    }
}