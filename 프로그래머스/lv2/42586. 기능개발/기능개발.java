import java.util.*;
class Solution {
    public List<Integer>  solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] days = new int[progresses.length];
        for(int i=0;i<progresses.length;i++){
            days[i] = (100-progresses[i])/speeds[i];
            days[i] += (100-progresses[i])%speeds[i] == 0 ? 0 : 1;
        }
        int count = 1;
        int day = days[0];
        for(int i=1;i<days.length;i++){
            if(days[i] > day){
                day = days[i];
                answer.add(count);
                count = 1;
            }else{
                count += 1;
            }
        }
        answer.add(count);
        return answer;
    }
}