import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int last = -1;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            switch (temp) {
                case "push": {
                    int tempInt = Integer.parseInt(st.nextToken());
                    queue.add(tempInt);
                    last = tempInt;
                    continue;
                }
                case "size": {
                    sb.append(queue.size());
                    break;
                }
                case "pop": {
                    if (queue.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(queue.poll());
                    }
                    break;
                }
                case "empty": {
                    sb.append(queue.isEmpty() ? 1 : 0);
                    break;
                }
                case "front": {
                    if (queue.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(queue.peek());
                    }
                    break;
                }
                default: {
                    if (queue.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(last);
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