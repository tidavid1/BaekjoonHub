import java.util.stream.*;
class Solution {
    public int solution(int[] num_list) {
        int answer = 1;
        if(num_list.length >=11){
            return IntStream.of(num_list).sum();
        }else{
            for(int num:num_list){
                answer *= num;
            }
        }
        return answer;
    }
}