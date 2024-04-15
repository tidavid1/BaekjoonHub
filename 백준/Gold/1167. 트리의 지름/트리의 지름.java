import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static int result = -1;
    private static boolean[] visited;
    private static int opponentNode;

    private static final Map<Integer, List<Edge>> MAP = new HashMap<>();

    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var n = Integer.parseInt(br.readLine());
            visited = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                var st = new StringTokenizer(br.readLine());
                var start = Integer.parseInt(st.nextToken());
                var list = MAP.getOrDefault(start, new ArrayList<>());
                while (st.hasMoreTokens()) {
                    var end = Integer.parseInt(st.nextToken());
                    if (end == -1) {
                        break;
                    }
                    var range = Integer.parseInt(st.nextToken());
                    list.add(new Edge(end, range));
                }
                MAP.put(start, list);
            }
        } catch (IOException ignore) {
        }
        dfs(1, 0);
        dfs(opponentNode, 0);
        try (var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(result));
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    private static void dfs(int node, int length) {
        if (length > result) {
            result = length;
            opponentNode = node;
        }
        visited[node] = true;
        for (Edge edge : MAP.get(node)) {
            if (!visited[edge.node]) {
                dfs(edge.node, length + edge.value);
            }
        }
        visited[node] = false;
    }

    private static class Edge {

        int node;
        int value;

        public Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}