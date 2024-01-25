import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static final Queue<Node> queue = new LinkedList<>();

    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        int x = -1;
        int y = -1;
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 2) {
                    x = i;
                    y = j;
                }
                arr[i][j] = temp - 2;
            }
        }
        queue.add(Node.of(x, y));
        while (!queue.isEmpty()) {
            bfs(n, m);
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j] == -2 ? 0 : arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int n, int m) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Node node = queue.poll();
            for (int j = 0; j < DX.length; j++) {
                int dx = node.x + DX[j];
                int dy = node.y + DY[j];
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && (arr[dx][dy] == -1)) {
                    arr[dx][dy] = arr[node.x][node.y] + 1;
                    queue.add(Node.of(dx, dy));
                }
            }
        }
    }

    static class Node {

        int x;
        int y;

        private Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Node of(int x, int y) {
            return new Node(x, y);
        }
    }
}