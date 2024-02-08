import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int max = Integer.MIN_VALUE;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int n;
    private static int m;

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }

        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            bw.write(String.valueOf(max));
            bw.flush();
        }
    }
    private static void dfs(int row, int col, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int dx = row + DX[i];
            int dy = col + DY[i];

            if (dx < 0 || dx >= n || dy < 0 || dy >= m) {
                continue;
            }

            if (!visited[dx][dy]) {
                if (depth == 2) {
                    visited[dx][dy] = true;
                    dfs(row, col, sum + arr[dx][dy], depth + 1);
                    visited[dx][dy] = false;
                }
                visited[dx][dy] = true;
                dfs(dx, dy, sum + arr[dx][dy], depth + 1);
                visited[dx][dy] = false;
            }
        }
    }
}