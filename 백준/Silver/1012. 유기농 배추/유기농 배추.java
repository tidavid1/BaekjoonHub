import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int[][] dxdy = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] arr = new int[m][n];
            boolean[][] visited = new boolean[m][n];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if (arr[j][l] == 1 && !visited[j][l]) {
                        dfs(j, l, m, n, arr, visited);
                        count += 1;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y, int m, int n, int[][] arr, boolean[][] visited) {
        visited[x][y] = true;
        for (int[] temp : dxdy) {
            int dx = x + temp[0] < 0 || x + temp[0] == m ? x : x + temp[0];
            int dy = y + temp[1] < 0 || y + temp[1] == n ? y : y + temp[1];
            if (visited[dx][dy] || arr[dx][dy] == 0) {
                continue;
            }
            dfs(dx, dy, m, n, arr, visited);
        }
    }

}