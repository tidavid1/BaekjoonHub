import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static int white = 0;
    private static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                arr[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        calculatePaper(0, 0, n);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(white));
        bw.newLine();
        bw.write(String.valueOf(blue));
        bw.flush();
        bw.close();
    }

    private static void calculatePaper(int x, int y, int size) {
        if (validateSameColor(x, y, size)) {
            if (arr[x][y] == 0) {
                white += 1;
            } else {
                blue += 1;
            }
            return;
        }
        calculatePaper(x, y, size / 2);
        calculatePaper(x + size / 2, y, size / 2);
        calculatePaper(x + size / 2, y + size / 2, size / 2);
        calculatePaper(x, y + size / 2, size / 2);
    }


    private static boolean validateSameColor(int x, int y, int size) {
        int color = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

}