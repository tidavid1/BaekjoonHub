import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
            while (st.hasMoreTokens()) {
                pq.add(Double.parseDouble(st.nextToken()));
            }
            if (pq.peek() == 0) {
                break;
            }
            double result = Math.pow(pq.poll(), 2);
            while (!pq.isEmpty()) {
                result -= Math.pow(pq.poll(), 2);
            }
            sb.append(result != 0 ? "wrong" : "right").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}