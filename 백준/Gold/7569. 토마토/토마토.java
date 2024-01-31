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

    private static int m;
    private static int n;
    private static int h;
    private static int[][][] arr;

    private static final int[] DX = {1, -1, 0, 0, 0, 0};
    private static final int[] DY = {0, 0, 1, -1, 0, 0};
    private static final int[] DZ = {0, 0, 0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new int[h][n][m];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    st = new StringTokenizer(br.readLine());
                    for (int k = 0; k < arr[i][j].length; k++) {
                        int temp = Integer.parseInt(st.nextToken());
                        arr[i][j][k] = temp;
                        if (temp == 1) {
                            QUEUE.add(new Node(i, j, k));
                        }
                    }
                }
            }
        }
        while (!QUEUE.isEmpty()) {
            bfs();
        }
        boolean flag = true;
        int result = -1;
        for (int[][] temp : arr) {
            for (int[] i : temp) {
                for (int j : i) {
                    if (j == 0) {
                        flag = false;
                    }
                    result = Math.max(result, j);
                }
            }
        }
        result = flag ? result - 1 : -1;
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(result));
            bw.flush();
        }
    }


    private static void bfs() {
        int size = QUEUE.size();
        for (int i = 0; i < size; i++) {
            Node node = QUEUE.poll();
            for (int j = 0; j < DX.length; j++) {
                int x = node.x + DX[j];
                int y = node.y + DY[j];
                int z = node.z + DZ[j];
                if (x >= 0 && x < h && y >= 0 && y < n && z >= 0 && z < m && (arr[x][y][z] == 0)) {
                    arr[x][y][z] = arr[node.x][node.y][node.z] + 1;
                    QUEUE.add(new Node(x, y, z));
                }
            }

        }
    }

    static class Node {

        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}