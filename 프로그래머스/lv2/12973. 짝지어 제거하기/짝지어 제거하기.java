import java.util.Stack;
class Solution{
    public int solution(String s){
        Stack<String> stack = new Stack<>();
        for(String c: s.split("")){
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            if(stack.peek().equals(c)){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}