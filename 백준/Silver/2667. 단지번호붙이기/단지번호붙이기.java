import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    private static final Queue<Integer> QUEUE = new PriorityQueue<>();

    private static int[][] arr;
    private static boolean[][] visited;
    private static int n;
    private static int count;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][];
            visited = new boolean[n][n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt)
                    .toArray();
            }
        }
        count = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    QUEUE.add(count);
                    count = 1;
                }
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();
            sb.append(QUEUE.size()).append("\n");
            while (!QUEUE.isEmpty()) {
                sb.append(QUEUE.poll()).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < DX.length; i++) {
            int dx = x + DX[i];
            int dy = y + DY[i];
            if (dx >= 0 && dx < n && dy >= 0 && dy < n && !visited[dx][dy] && (arr[dx][dy] == 1)) {
                count += 1;
                dfs(dx, dy);
            }
        }
    }


}