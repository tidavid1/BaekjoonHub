import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;
    private static boolean[] visited;

    private static final Map<Integer, List<Integer>> MAP = new HashMap<>();

    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            for (int i = 1; i < n; i++) {
                var st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                var list = MAP.getOrDefault(node1, new ArrayList<>());
                list.add(node2);
                MAP.put(node1, list);
                list = MAP.getOrDefault(node2, new ArrayList<>());
                list.add(node1);
                MAP.put(node2, list);
            }
        } catch (IOException ignore) {

        }
        dfs(1, 0);
        try (var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 2; i < arr.length; i++) {
                bw.write(String.valueOf(arr[i]));
                bw.newLine();
            }
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    private static void dfs(int current, int parent) {
        if (current != 1) {
            arr[current] = parent;
        }
        var list = MAP.get(current);
        for (int i : list) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, current);
                visited[i] = false;
            }
        }
    }
}