import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) == 'W';
            }
        }
        int nRow = n - 7;
        int mCol = m - 7;
        int min = 64;
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < mCol; j++) {
                min = Math.min(calculate(i, j, arr), min);
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }


    public static int calculate(int x, int y, boolean[][] arr) {
        int endX = x + 8;
        int endY = y + 8;
        int count = 0;

        boolean flag = arr[x][y];

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (arr[i][j] != flag) {
                    count++;
                }
                flag = !flag;
            }
            flag = !flag;
        }
        return Math.min(count, 64 - count);
    }
}