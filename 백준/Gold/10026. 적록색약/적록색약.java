import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int n;
    private static char[][] arr;
    private static boolean[][] visited;
    private static final int[] RESULT = {0, 0};
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            arr = new char[n][];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine().toCharArray();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!visited[i][j]) {
                    RESULT[0] += 1;
                    dfs(i, j);
                }
            }
        }
        visited = new boolean[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!visited[i][j]) {
                    RESULT[1] += 1;
                    dfsWithBlindness(i, j);
                }
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(RESULT[0] + " " + RESULT[1]);
            bw.flush();
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < DX.length; i++) {
            int dx = x + DX[i];
            int dy = y + DY[i];
            if (dx < 0 || dx == n || dy < 0 || dy == n) {
                continue;
            }
            if (!visited[dx][dy] && arr[dx][dy] == arr[x][y]) {
                dfs(dx, dy);
            }
        }
    }

    private static void dfsWithBlindness(int x, int y) {
        visited[x][y] = true;
        char color = arr[x][y];
        for (int i = 0; i < DX.length; i++) {
            int dx = x + DX[i];
            int dy = y + DY[i];
            if (dx < 0 || dx == n || dy < 0 || dy == n) {
                continue;
            }
            if (!visited[dx][dy]) {
                if (color == 'B') {
                    if (arr[dx][dy] == 'B') {
                        dfsWithBlindness(dx, dy);
                    }
                } else {
                    if (arr[dx][dy] != 'B') {
                        dfsWithBlindness(dx, dy);
                    }
                }

            }
        }
    }

}