import java.util.Stack;
class Solution {
    public int solution(int n) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        while(n !=0){
            stack.add(n%3);
            n /=3;
        }
        int i=0;
        while(!stack.isEmpty()){
            answer += stack.pop()*Math.pow(3,i++);
        }
        return answer;
    }
}