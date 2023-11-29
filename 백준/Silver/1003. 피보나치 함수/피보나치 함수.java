import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(br.readLine());
            bw.write(String.format("%d %d", dp[index][0], dp[index][1]));
            if (i != n - 1) {
                bw.write("\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
