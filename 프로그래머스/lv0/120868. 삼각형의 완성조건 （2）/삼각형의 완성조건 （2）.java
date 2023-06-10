import java.util.Arrays;
class Solution {
    public int solution(int[] sides) {
        return Arrays.stream(sides).min().getAsInt()*2-1;
    }
}