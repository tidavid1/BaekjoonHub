import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] result = new int[2];
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        if(gemSet.size() == 1){
            return new int[]{1,1};
        }
        Map<String, Integer> map = new HashMap<>();
        int length = Integer.MAX_VALUE;
        int start = 0;
        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            while(map.getOrDefault(gems[start], 0) > 1){
                map.put(gems[start], map.get(gems[start]) - 1);
                start += 1;
            }
            if(map.size() == gemSet.size() && length > (end - start + 1)){
                length = end -start + 1;
                result[0] = start + 1;
                result[1] = end + 1;
            }
        }
        return result;
    }
}