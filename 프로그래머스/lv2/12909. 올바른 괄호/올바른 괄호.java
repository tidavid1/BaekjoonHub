import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char temp:s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(temp);
                continue;
            }
            if(temp == ')' && stack.peek() == '('){
                stack.pop();
            }else{
                stack.push(temp);
            }
        }
        return stack.isEmpty();
    }
}