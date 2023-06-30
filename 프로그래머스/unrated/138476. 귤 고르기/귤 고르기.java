import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        Map<Integer, Integer> table = new HashMap<>();
        Map<Integer, List<Integer>> temp = new HashMap<>();
        for(int i:tangerine){
            table.put(i, table.getOrDefault(i, 0)+1);
        }
        for(int i:table.keySet()){
            List<Integer> x = temp.getOrDefault(table.get(i), new ArrayList<>());
            x.add(i);
            temp.put(table.get(i), x);
        }
        for(int i:temp.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())){
            for(int j:temp.get(i)){
                k -= i;
                answer += 1;
                if(k <=0){
                    return answer;
                }
            }
        }
        return answer;
    }
}