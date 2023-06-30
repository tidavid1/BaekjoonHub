import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb;
        for(int i=0;i<s.length();i++){
            sb = new StringBuilder();
            sb.append(s.substring(i+1)).append(s.substring(0,i+1));
            Stack<Integer> stack = new Stack<>();
            for(char c:sb.toString().toCharArray()){
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