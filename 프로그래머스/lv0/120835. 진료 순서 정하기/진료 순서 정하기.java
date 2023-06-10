import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] emergency) {
        int[] target = emergency.clone();
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(emergency);
        for(int i=0;i<emergency.length/2;i++){
            int temp = emergency[i];
            emergency[i] = emergency[emergency.length-i-1];
            emergency[emergency.length-i-1] = temp;
        }
        for(int i:target){
            for(int j=0;j<emergency.length;j++){
                if(i == emergency[j]) answer.add(j+1);
            }
        }
        return answer;
    }
}