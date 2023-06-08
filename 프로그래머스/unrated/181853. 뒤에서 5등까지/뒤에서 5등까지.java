import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[5];
        Arrays.sort(num_list);
        System.arraycopy(num_list, 0, answer, 0, answer.length);
        return answer;
    }
}