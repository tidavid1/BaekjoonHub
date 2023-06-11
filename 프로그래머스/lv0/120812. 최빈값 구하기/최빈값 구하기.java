import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        boolean flag = false;
        HashMap<Integer, Integer> values = new HashMap<>();
        for(int i:array){
            values.put(i, values.get(i) == null ? 1 : values.get(i)+1);
        }
        int max = -1;
        for(int i:values.values()){
            if(i>max) max= i;
        }
        for(Map.Entry<Integer, Integer> m:values.entrySet()){
            if(m.getValue().equals(max)){
                if (flag){
                    answer = -1;
                    break;
                }
                answer = m.getKey();
                flag = true;
            }
        }
        return answer;
    }
}