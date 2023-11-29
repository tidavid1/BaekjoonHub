import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] dp = new int[15][14];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i + 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        int number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(String.format("%d", dp[k][n - 1]));
            if (i != number - 1) {
                bw.write("\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
