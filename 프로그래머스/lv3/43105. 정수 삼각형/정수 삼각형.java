import java.util.*;
class Solution {
    public int solution(int[][] t) {
        for(int i=1;i<t.length;i++){
            for(int j=0;j<t[i].length;j++){
                t[i][j] += Math.max(t[i-1][j==t[i-1].length?j-1 : j], t[i-1][j==0?j:j-1]);
            }
        }
        return Arrays.stream(t[t.length-1]).max().getAsInt();
    }
}