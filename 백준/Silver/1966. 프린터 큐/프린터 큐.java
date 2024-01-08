import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int m = Integer.parseInt(st.nextToken());
            Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                pq.add(temp);
                queue.add(new int[]{idx++, temp});
            }
            int count = 0;
            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                if (pq.peek().equals(temp[1])) {
                    pq.poll();
                    count += 1;
                    if (temp[0] == m) {
                        break;
                    }
                } else {
                    queue.add(temp);
                }
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}