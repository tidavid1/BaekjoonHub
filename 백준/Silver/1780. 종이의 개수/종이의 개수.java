import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] arr;

    private static final int[] results = new int[3];

    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            }
        } catch (IOException ignore) {
        }
        paper(0, 0, n);
        try (var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int result : results) {
                bw.write(String.valueOf(result));
                bw.newLine();
            }
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    private static void paper(int x, int y, int n) {
        if (verifyPaper(x, y, n)) {
            results[arr[x][y] + 1] += 1;
            return;
        }
        n /= 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                paper(x+n*i, y+n*j, n);
            }
        }
    }

    private static boolean verifyPaper(int x, int y, int n) {
        var color = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}