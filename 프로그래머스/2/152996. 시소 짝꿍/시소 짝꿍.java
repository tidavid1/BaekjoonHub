import java.util.*;

class Solution {
    
    private final double[] ratios = {1.0, (2.0/3.0), .5, .75};

    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Integer, Integer> map = new HashMap<>();
        for(int weight: weights){
            for(double ratio: ratios){
                double value = weight * ratio;
                if (value % 1 == 0.0) {
                    answer += map.getOrDefault((int) value, 0);
                }
            }
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }
        return answer;
    }
}