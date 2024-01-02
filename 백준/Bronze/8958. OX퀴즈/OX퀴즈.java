import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(br.readLine().split("")));
            int totalScore = 0;
            int score = 1;
            while (!queue.isEmpty()) {
                String poll = queue.poll();
                if (poll.equals("O")) {
                    totalScore += score;
                    score++;
                } else {
                    score = 1;
                }
            }
            bw.write(String.valueOf(totalScore));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}