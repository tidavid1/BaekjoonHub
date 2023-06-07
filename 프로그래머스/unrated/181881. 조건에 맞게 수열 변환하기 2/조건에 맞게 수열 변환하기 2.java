import java.util.*;
class Solution {
    public int[] getArr(int[] arr, int n){
        int[] temp = arr.clone();
        for(int i=0;i<n;i++){
            for(int j=0;j<temp.length;j++){
                if(temp[j] >= 50 && temp[j]%2==0){
                    temp[j] /=2;
                }else if(temp[j] < 50 && temp[j]%2==1){
                    temp[j] *= 2;
                    temp[j] += 1;
                }
            }
        }
        return temp;
    }
    public int solution(int[] arr) {
        int answer = 0;
        int[] temp1 = getArr(arr, answer);
        int[] temp2 = getArr(arr, answer+1);
        while(!Arrays.equals(temp1, temp2)){
            answer++;
            temp1 = getArr(arr, answer);
            temp2 = getArr(arr, answer+1);
        }
        return answer;
    }
}