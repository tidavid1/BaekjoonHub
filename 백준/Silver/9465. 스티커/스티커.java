import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static int[][] dp;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                arr = new int[2][n + 1];
                dp = new int[2][n + 1];
                for (int i = 0; i < arr.length; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for (int j = 1; j < arr[i].length; j++) {
                        arr[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                dp[0][1] = arr[0][1];
                dp[1][1] = arr[1][1];
                for (int i = 2; i < n + 1; i++) {
                    dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
                    dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
                }
                sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
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
