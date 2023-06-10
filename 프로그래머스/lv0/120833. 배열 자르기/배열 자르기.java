import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] numbers, int num1, int num2) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(;num1 <= num2; num1++){
            answer.add(numbers[num1]);
        }
        return answer;
    }
}