import java.io.*;

public class Main {

    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static int n;
    private static int[][] arr;

    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                var temp = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = temp.charAt(j) - '0';
                }
            }
        } catch (IOException ignore) {
        }
        zip(0, 0, n);
        try (var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(STRING_BUILDER.toString());
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    private static void zip(int x, int y, int n) {
        if (verifySquare(x, y, n)) {
            STRING_BUILDER.append(arr[x][y]);
            return;
        }
        n /= 2;
        STRING_BUILDER.append("(");
        zip(x, y, n);
        zip(x, y + n, n);
        zip(x + n, y, n);
        zip(x + n, y + n, n);
        STRING_BUILDER.append(")");
    }

    private static boolean verifySquare(int x, int y, int n) {
        int color = arr[x][y];
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