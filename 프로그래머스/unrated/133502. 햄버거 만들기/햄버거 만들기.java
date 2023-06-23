import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i:ingredient){
            if(stack.size() < 3){
                stack.push(i);
                continue;
            }
            stack.push(i);
            if(stack.subList(stack.size()-4, stack.size()).equals(Arrays.stream(new int[]{1, 2, 3, 1}).boxed().collect(Collectors.toList()))){
                answer+=1;
                for(int j=0;j<4;j++){
                    stack.pop();
                }
            }
        }
        return answer;
    }
}