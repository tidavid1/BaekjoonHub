import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (!queue.contains(word)) {
                queue.add(word);
            }
        }
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}