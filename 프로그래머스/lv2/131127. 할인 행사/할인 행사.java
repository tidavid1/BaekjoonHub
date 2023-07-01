import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        final int DAYS = 10;
        Map<String ,Integer> table = new HashMap<>();
        for(int i=0;i<want.length;i++){
            table.put(want[i], number[i]);
        }
        for(int i=0;i<discount.length-DAYS+1;i++){
            Map<String, Integer> discountTable = new HashMap<>();
            boolean flag = true;
            for(int j = i; j<DAYS+i;j++){
                discountTable.put(discount[j], discountTable.getOrDefault(discount[j], 0)+1);
            }
            for(String s: table.keySet()){
                if(table.get(s) > discountTable.getOrDefault(s,0)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer += 1;
            }
        }
        
        return answer;
    }
}