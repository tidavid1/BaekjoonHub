import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            switch (temp) {
                case "push_front": {
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    continue;
                }
                case "push_back": {
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    continue;
                }
                case "pop_front": {
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst());
                    break;
                }
                case "pop_back": {
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast());
                    break;
                }
                case "empty": {
                    sb.append(deque.isEmpty() ? 1 : 0);
                    break;
                }
                case "front": {
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst());
                    break;
                }
                case "back": {
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast());
                    break;
                }
                default: {
                    sb.append(deque.size());
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