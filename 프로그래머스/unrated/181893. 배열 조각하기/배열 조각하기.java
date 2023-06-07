import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        boolean flag = true;
        for (int i:query){
            if (flag){
                arr = Arrays.copyOfRange(arr, 0, i+1);
                flag = false;
            } else{
                arr = Arrays.copyOfRange(arr, i, arr.length);
                flag= true;
            }
        }
        
        return arr;
    }
}