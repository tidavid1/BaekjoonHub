import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n + 1][n + 1];
            int[][] dp = new int[n + 1][n + 1];
            for (int i = 1; i < arr.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < arr[i].length; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
                }
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int startX = Integer.parseInt(st.nextToken());
                int startY = Integer.parseInt(st.nextToken());
                int endX = Integer.parseInt(st.nextToken());
                int endY = Integer.parseInt(st.nextToken());
                int answer =
                    dp[endX][endY] - dp[endX][startY - 1] - dp[startX - 1][endY] + dp[startX - 1][
                        startY - 1];
                sb.append(answer).append("\n");
            }
        } catch (IOException ignore) {
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException ignore) {
        }
    }
}
