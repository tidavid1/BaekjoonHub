import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack<Integer>> table = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i< board.length;i++){
            table.add(new Stack<>());
        }
        for(int i=0;i< board.length;i++){
            for(int j = board[i].length-1;j>=0;j--){
                if(board[j][i]!= 0)
                    table.get(i).push(board[j][i]);
            }
        }
        for(int move:moves){
            if(table.get(move-1).size() == 0){
                continue;
            }
            if(stack.size() == 0){
                stack.push(table.get(move-1).pop());
            }else{
                if(stack.peek() == table.get(move-1).peek()){
                    table.get(move-1).pop();
                    stack.pop();
                    answer += 2;
                }else {
                    stack.push(table.get(move-1).pop());
                }
            }
        }
        return answer;
    }
}