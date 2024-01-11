import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (true) {
            boolean flag = true;
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            s = s.replaceAll("[A-Z]*[a-z]*\\s*", "");
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[') {
                    stack.add(c);
                } else if (c == ')' || c == ']') {
                    if (stack.isEmpty()) {
                        flag = false;
                        continue;
                    }
                    flag = flag && (stack.peek() + 1 == c || stack.peek() + 2 == c);
                    if (flag) {
                        stack.pop();
                    }
                }
            }
            flag = flag && stack.isEmpty();
            sb.append(flag ? "yes" : "no").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}