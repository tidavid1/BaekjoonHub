import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
            s = s.substring(1) + s.substring(0,1);
            Stack<Integer> stack = new Stack<>();
            for(char c:s.toCharArray()){
                if(stack.isEmpty()){
                    stack.push((int)c);
                    continue;
                }
                if(stack.peek()+1 == (int)c || stack.peek()+2 ==(int)c){
                    stack.pop();
                    continue;
                }
                stack.push((int)c);
            }
            if(stack.isEmpty()){
                answer += 1;
            }
        }
        return answer;
    }
}