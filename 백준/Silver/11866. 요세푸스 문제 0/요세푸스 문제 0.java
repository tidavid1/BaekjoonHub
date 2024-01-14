import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int[] answer = new int[n];
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int idx = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            count += 1;
            if (count == k) {
                answer[idx++] = temp;
                count = 0;
            } else {
                queue.add(temp);
            }
        }
        bw.write(Arrays.toString(answer).replace('[', '<').replace(']', '>'));
        bw.flush();
        bw.close();
        br.close();
    }

}