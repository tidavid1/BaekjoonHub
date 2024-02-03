import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_LENGTH = 10000;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                Queue<Integer> queue = new LinkedList<>();
                boolean[] visited = new boolean[MAX_LENGTH];
                Map<Integer, String> map = new HashMap<>();
                StringTokenizer st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int result = Integer.parseInt(st.nextToken());
                queue.add(value);
                visited[value] = true;
                while (!queue.isEmpty() && !visited[result]) {
                    int now = queue.poll();
                    int d = (2 * now) % MAX_LENGTH;
                    int s = now == 0 ? 9999 : now - 1;
                    int l = (now % 1000) * 10 + now / 1000;
                    int r = (now % 10) * 1000 + now / 10;
                    if (!visited[d]) {
                        queue.add(d);
                        visited[d] = true;
                        map.put(d, map.getOrDefault(now, "") + "D");
                    }
                    if (!visited[s]) {
                        queue.add(s);
                        visited[s] = true;
                        map.put(s, map.getOrDefault(now, "") + "S");
                    }
                    if (!visited[l]) {
                        queue.add(l);
                        visited[l] = true;
                        map.put(l, map.getOrDefault(now, "") + "L");
                    }
                    if (!visited[r]) {
                        queue.add(r);
                        visited[r] = true;
                        map.put(r, map.getOrDefault(now, "") + "R");
                    }
                }
                sb.append(map.get(result)).append("\n");
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(sb.toString());
            bw.flush();
        }
    }


}