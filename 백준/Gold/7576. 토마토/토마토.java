import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[][] arr;
    private static final Queue<Node> queue = new LinkedList<>();
    private static final int[] dx = new int[]{1, -1, 0, 0};
    private static final int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                if (temp == 1) {
                    queue.add(new Node(i, j));
                }
            }
        }
        br.close();
        while (!queue.isEmpty()) {
            bfs();
        }
        boolean flag = true;
        int result = -1;
        for (int[] temp : arr) {
            for (int i : temp) {
                if (i == 0) {
                    flag = false;
                }
                result = Math.max(result, i);
            }
        }
        result = flag ? result - 1 : -1;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Node node = queue.poll();
            for (int j = 0; j < dx.length; j++) {
                int x = node.x + dx[j];
                int y = node.y + dy[j];
                if (x >= 0 && x < n && y >= 0 && y < m && (arr[x][y] == 0)) {
                    arr[x][y] = arr[node.x][node.y] + 1;
                    queue.add(new Node(x, y));
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