import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] dice = {a,b,c,d};
        HashMap<Integer, Integer> table = new HashMap<>();
        for(int i: dice){
            table.put(i, table.get(i) == null ? 1 : table.get(i)+1);
        }
        int[] keyArr = table.keySet().stream().mapToInt(Integer::intValue).toArray();
        switch(table.values().size()){
                case 4 -> {
                    answer = 7;
                    for(int i:keyArr){
                        answer = Math.min(answer, i);
                    }
                }
                case 3 -> {
                    answer = 1;
                    for(Map.Entry<Integer, Integer> entry: table.entrySet()){
                        if(entry.getValue().equals(1)){
                            answer *= entry.getKey();
                        }
                    }
                }
                case 2 -> {
                    if(table.containsValue(3)){
                        for(Map.Entry<Integer, Integer> entry: table.entrySet()){
                            if(entry.getValue().equals(3)){
                                answer += 10*entry.getKey();
                            }else{
                                answer += entry.getKey();
                            }
                        }
                        answer *= answer;
                    }else{
                        answer = (keyArr[0]+keyArr[1]) * Math.abs(keyArr[0]-keyArr[1]);
                    }
                }
                default -> answer = 1111 * keyArr[0];
        }
        return answer;
    }
}