import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            int temp = map.getOrDefault(number, 0) + 1;
            map.put(number, temp);
            count = Math.max(count, temp);
            sum += number;
            arr[i] = number;
            min = Math.min(number, min);
            max = Math.max(number, max);
        }

        int finalCount = count;
        Queue<Integer> pq = new PriorityQueue<>();
        map.forEach((key, value) -> {
            if (value == finalCount) {
                pq.add(key);
            }
        });
        Arrays.sort(arr);
        if (pq.size() == 1) {
            count = pq.poll();
        } else {
            pq.poll();
            count = pq.poll();
        }
        sb.append((int) Math.round((double) sum / n)).append("\n")
            .append(arr[n / 2]).append("\n")
            .append(count).append("\n")
            .append(max - min);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}