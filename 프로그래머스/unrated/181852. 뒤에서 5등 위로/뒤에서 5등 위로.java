import java.util.Arrays;
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length-5];
        Arrays.sort(num_list);
        System.arraycopy(num_list, 5, answer, 0, answer.length);
        return answer;
    }
}