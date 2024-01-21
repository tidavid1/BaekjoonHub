import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_NUMBER = 100001;
    private static final int[] arr = new int[MAX_NUMBER];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        br.close();
        int result = n == m ? 0 : bfs(n, m);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int bfs(int n, int m) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        arr[n] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < 3; i++) {
                int next = node;
                switch (i) {
                    case 0: {
                        next += 1;
                        break;
                    }
                    case 1: {
                        next -= 1;
                        break;
                    }
                    default: {
                        next *= 2;
                    }
                }
                if (next == m) {
                    return arr[node];
                }
                if (next >= 0 && next < arr.length && arr[next] == 0) {
                    queue.add(next);
                    arr[next] = arr[node] + 1;
                }
            }
        }
        return -1;
    }
}