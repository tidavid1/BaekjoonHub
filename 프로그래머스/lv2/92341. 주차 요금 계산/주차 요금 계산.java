import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        final int TIME_LAST = 1439;
        Map<String, Boolean> check = new HashMap<>();
        Map<String, Integer> table = new HashMap<>();
        for(String record:records){
            String[] temp = record.split(" ");
            int minutes = Integer.parseInt(temp[0].split(":")[0])*60 + Integer.parseInt(temp[0].split(":")[1]);
            if(record.contains("IN")){
                check.put(temp[1], true);
                table.put(temp[1], minutes - table.getOrDefault(temp[1], 0));

            }else{
                check.put(temp[1], false);
                table.put(temp[1], minutes - table.get(temp[1]));
            }
        }

        for(String s:check.keySet()){
            if(check.get(s)){
                table.put(s, TIME_LAST-table.get(s));
            }
        }
        int[] answer = new int[check.size()];
        int idx = 0;
        for(String s:check.keySet().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList())){
            if(table.get(s) <= fees[0])
                answer[idx++] = fees[1];
            else
                answer[idx++] = (int) (fees[1]+Math.ceil((double)(table.get(s)-fees[0])/fees[2])*fees[3]);
        }
        return answer;
    }
}