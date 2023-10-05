import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (maxQueue.size() == minQueue.size()) {
                maxQueue.add(num);
            } else {
                minQueue.add(num);
            }

            if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
                if (maxQueue.peek() > minQueue.peek()) {
                    int tmp = maxQueue.poll();
                    maxQueue.offer(minQueue.poll());
                    minQueue.offer(tmp);
                }
            }
            sb.append(maxQueue.peek()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
