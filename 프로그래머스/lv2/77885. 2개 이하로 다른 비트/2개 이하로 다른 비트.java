import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]%2==0){
                answer[i] = numbers[i]+1;
            }else{
                StringBuilder sb = new StringBuilder();
                String binary = Long.toBinaryString(numbers[i]);
                if(!binary.contains("0")){
                    sb.append("10").append(binary.substring(1));
                }else{
                    int last = binary.lastIndexOf("0");
                    int first = binary.indexOf("1", last);
                    sb.append(binary, 0, last).append("1").append("0").append(binary.substring(first + 1));
                }
                answer[i] = Long.parseLong(sb.toString(), 2);
            }
        }
        
        return answer;
    }
    
}