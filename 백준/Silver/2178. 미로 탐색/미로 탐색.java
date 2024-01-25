import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Queue<Node> queue = new LinkedList<>();
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    private static int[][] arr;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        br.close();
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            bfs();
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(arr[n - 1][m - 1]));
        bw.flush();
        bw.close();
    }

    private static void bfs(){
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Node node = queue.poll();
            for (int j = 0; j < DX.length; j++) {
                int x = node.x + DX[j];
                int y = node.y + DY[j];
                if (x >= 0 && x < n && y >= 0 && y < m && (arr[x][y] == 1)) {
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