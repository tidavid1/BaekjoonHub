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
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    stack.add(s.charAt(j));
                } else {
                    if (stack.isEmpty()){
                        flag = false;
                        break;
                    }
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }
            flag = flag && stack.isEmpty();
            sb.append(flag ? "YES" : "NO").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}