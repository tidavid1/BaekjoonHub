import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    private static final Queue<Node> QUEUE = new LinkedList<>();
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    private static int n;
    private static int m;
    private static char[][] arr;
    private static boolean[][] visited;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new char[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                String temp = br.readLine();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = temp.charAt(j);
                    if (temp.charAt(j) == 'I') {
                        QUEUE.add(new Node(i, j));
                        visited[i][j] = true;
                    }
                }
            }
        }
        while (!QUEUE.isEmpty()) {
            bfs();
        }
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(result == 0 ? "TT" : String.valueOf(result));
            bw.flush();
        }
    }

    private static void bfs() {
        int size = QUEUE.size();
        for (int i = 0; i < size; i++) {
            Node node = QUEUE.poll();
            for (int j = 0; j < DX.length; j++) {
                int dx = node.x + DX[j];
                int dy = node.y + DY[j];
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && (arr[dx][dy] != 'X') && !visited[dx][dy]) {
                    if (arr[dx][dy] == 'P') {
                        result += 1;
                    }
                    visited[dx][dy] = true;
                    QUEUE.add(new Node(dx, dy));
                }
            }
        }

    }

    static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}