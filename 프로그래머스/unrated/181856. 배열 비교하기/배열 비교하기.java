import java.util.Arrays;
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = arr1.length>arr2.length ? 1 : arr1.length == arr2.length ? 0 : -1;
        if(answer == 0){
            if(Arrays.stream(arr1).sum() >Arrays.stream(arr2).sum() ) answer = 1;
            else if(Arrays.stream(arr1).sum() < Arrays.stream(arr2).sum() ) answer = -1;
        }
        return answer;
    }
}