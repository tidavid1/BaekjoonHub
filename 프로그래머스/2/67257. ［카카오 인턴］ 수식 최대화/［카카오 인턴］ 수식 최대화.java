import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("50*6-3*2"));
    }

    private final char[] operators = {'*', '-', '+'};
    private final boolean[] visited = new boolean[3];
    private final Deque<Long> valueDeque = new LinkedList<>();
    private final Queue<Character> operatorQueue = new LinkedList<>();
    private long answer = 0;

    public long solution(String expression) {
        splitExpression(expression);
        for (int i = 0; i < visited.length; i++) {
            dfs(i, valueDeque, operatorQueue, 0);
        }
        return answer;
    }

    private void dfs(int idx, Deque<Long> deque, Queue<Character> queue, int depth) {
        var currentOperation = operators[idx];
        Deque<Long> tempDeque = new LinkedList<>(deque);
        Queue<Character> tempQueue = new LinkedList<>(queue);
        var size = tempQueue.size();
        while (size-- > 0) {
            var value = tempDeque.poll();
            var operator = tempQueue.poll();
            if (operator == currentOperation) {
                tempDeque.addFirst(calculate(value, currentOperation, tempDeque.poll()));
            } else {
                tempDeque.add(value);
                tempQueue.add(operator);
            }
            if (size == 0) {
                tempDeque.add(tempDeque.poll());
            }
        }
        if (depth == 2) {
            answer = Math.max(Math.abs(tempDeque.poll()), answer);
            return;
        }
        visited[idx] = true;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i, tempDeque, tempQueue, depth + 1);
            }
        }
        visited[idx] = false;
    }

    private long calculate(long value1, char operator, long value2) {
        return switch (operator) {
            case '+' -> value1 + value2;
            case '-' -> value1 - value2;
            default -> value1 * value2;
        };
    }

    private void splitExpression(String s) {
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c == '*' || c == '-' || c == '+') {
                valueDeque.add(Long.parseLong(s.substring(idx, i)));
                operatorQueue.add(s.charAt(i));
                idx = i + 1;
            }
        }
        valueDeque.add(Long.parseLong(s.substring(idx)));
    }
}