import java.io.*;

public class Main {

    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static int n;

    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
        } catch (IOException ignore) {
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                star(i, j, n);
            }
            STRING_BUILDER.append("\n");
        }
        try (var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(STRING_BUILDER.toString());
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    private static void star(int x, int y, int n) {
        if ((x / n) % 3 == 1 && (y / n) % 3 == 1) {
            STRING_BUILDER.append(" ");
        } else {
            if (n == 1) {
                STRING_BUILDER.append("*");
            } else {
                star(x, y, n / 3);
            }
        }
    }
}