import java.util.*;
class Solution {
    public int solution(int[] order) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        for(int i=1;i<=order.length;i++){
            queue.add(i);
        }
        for(int i:order){
            if(queue.isEmpty()){
                if(stack.peek() == i){
                    answer.add(stack.pop());
                }else{
                    break;
                }
            }else{
                if(queue.peek() <= i){
                    while(queue.peek() < i){
                        stack.push(queue.poll());
                    }
                    answer.add(queue.poll());
                }else{
                    if(stack.peek() == i){
                        answer.add(stack.pop());
                    }else{
                        break;
                    }
                }
            }
        }
        return answer.size();
    }
}