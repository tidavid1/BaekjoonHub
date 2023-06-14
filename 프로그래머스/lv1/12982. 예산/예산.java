import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        for(int i=0;i<d.length;i++){
            budget -= d[i];
            if(budget <0) return i;
        }
        return d.length;
    }
}