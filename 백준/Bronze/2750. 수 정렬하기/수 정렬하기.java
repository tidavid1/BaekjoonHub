import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}