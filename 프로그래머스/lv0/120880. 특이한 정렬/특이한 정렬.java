import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] is_negative = new int[numlist.length];
        for(int i=0;i<numlist.length;i++){
            if(numlist[i]-n<0) is_negative[i] = 1;
            numlist[i] = Math.abs(numlist[i]-n);
        }
        for(int i=0;i<numlist.length;i++){
            for(int j = i+1;j<numlist.length;j++){
                if(numlist[i] > numlist[j]){
                    int temp = numlist[i];
                    numlist[i] = numlist[j];
                    numlist[j] = temp;
                    temp = is_negative[i];
                    is_negative[i] = is_negative[j];
                    is_negative[j] = temp;
                }
            }
        }
        for(int i=0;i<numlist.length;i++){
            if(is_negative[i] == 1){
                if(i+1 < numlist.length){
                    if(numlist[i] == numlist[i+1]){
                    numlist[i] = numlist[i++]+n;
                    }
                }
                numlist[i] = (numlist[i]*-1) + n;

            }else{
                numlist[i] +=n;
            }
        }
        return numlist;
    }
}