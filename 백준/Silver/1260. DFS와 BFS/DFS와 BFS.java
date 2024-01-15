import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int v;
    private static int[][] arr;
    private static boolean[] visited;
    private static final Queue<Integer> QUEUE = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        arr = new int[1001][1001];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }
        int count = 0;
        dfs(v, count);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);
        br.close();
    }

    private static void bfs(int number) {
        QUEUE.offer(number);
        visited[number] = true;
        System.out.print(number);
        System.out.print(" ");
        while (!QUEUE.isEmpty()) {
            number = QUEUE.poll();
            for (int i = 1; i <= n; i++) {
                if (arr[number][i] != 0 && !visited[i]) {
                    QUEUE.offer(i);
                    visited[i] = true;
                    System.out.print(i);
                    System.out.print(" ");
                }
            }
        }
    }

    private static void dfs(int number, int count) {
        visited[number] = true;
        System.out.print(number);
        System.out.print(" ");
        if (count == n) {
            return;
        }
        count += 1;
        for (int i = 1; i <= n; i++) {
            if (arr[number][i] != 0 && !visited[i]) {
                dfs(i, count);
            }
        }

    }

}