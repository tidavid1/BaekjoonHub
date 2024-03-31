import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] arr;
    private static int min = Integer.MAX_VALUE;
    private static boolean[] visited;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n];
            arr = new int[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            }
        } catch (IOException ignore) {
        }
        dfs(0, 0);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(min));
            bw.flush();
        } catch (IOException ignore) {
        }

    }

    private static void dfs(int idx, int depth) {
        if (depth == n / 2) {
            int visitedScore = 0;
            int notVisitedScore = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        visitedScore += arr[i][j] + arr[j][i];
                    }
                    if (!visited[i] && !visited[j]) {
                        notVisitedScore += arr[i][j] + arr[j][i];
                    }
                }
            }
            min = Math.min(Math.abs(visitedScore - notVisitedScore), min);
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }

    }
}