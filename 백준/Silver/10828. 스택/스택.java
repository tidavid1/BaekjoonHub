import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            switch (temp) {
                case "push": {
                    stack.add(Integer.parseInt(st.nextToken()));
                    continue;
                }
                case "size": {
                    sb.append(stack.size());
                    break;
                }
                case "pop": {
                    if (stack.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(stack.pop());
                    }
                    break;
                }
                case "empty": {
                    sb.append(stack.isEmpty() ? 1 : 0);
                    break;
                }
                default: {
                    if (stack.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(stack.peek());
                    }
                    break;
                }

            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}