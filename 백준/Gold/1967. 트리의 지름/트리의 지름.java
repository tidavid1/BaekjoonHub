import java.io.*;
import java.util.*;

public class Main {

    private static ArrayList<Integer[]>[] graph;
    private static boolean[] visited;
    private static int max = 0;
    private static int findNode = 1;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            visited = new boolean[n + 1];
            graph = new ArrayList[n + 1];
            for (int i = 1; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            while (n-- > 1) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph[node1].add(new Integer[]{node2, cost});
                graph[node2].add(new Integer[]{node1, cost});
            }
        } catch (IOException ignore) {
        }
        dfs(1, 0);
        max = 0;
        Arrays.fill(visited, false);
        dfs(findNode, 0);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(max));
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    public static void dfs(int node, int sum) {
        visited[node] = true;
        if (sum > max) {
            max = sum;
            findNode = node;
        }

        for (Integer[] arr : graph[node]) {
            int next = arr[0];
            int cost = arr[1];
            if (!visited[next]) {
                dfs(next, sum + cost);
            }
        }


    }

}