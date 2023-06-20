import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n - lost.length;
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i] == reserve[j]){
                    answer +=1;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer +=1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}