import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new PriorityQueue<>();
        int result = 0;
        int prev = 0;
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i : arr) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            prev += queue.poll();
            result += prev;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}