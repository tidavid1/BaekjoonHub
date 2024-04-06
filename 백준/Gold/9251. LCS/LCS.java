import java.util.*;
import java.io.*;

public class Main {

    private static char[] str1;
    private static char[] str2;
    private static int[][] dp;

    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            str1 = br.readLine().toCharArray();
            str2 = br.readLine().toCharArray();
            dp = new int[str1.length][str2.length];
            for (int[] arr : dp) {
                Arrays.fill(arr, -1);
            }
        } catch (IOException ignore) {
        }

        try (var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(lcs(str1.length - 1, str2.length - 1)));
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    private static int lcs(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }
        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            if (str1[x] == str2[y]) {
                dp[x][y] = lcs(x - 1, y - 1) + 1;
            } else {
                dp[x][y] = Math.max(lcs(x - 1, y), lcs(x, y - 1));
            }
        }
        return dp[x][y];
    }
}