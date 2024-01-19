import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_DISTANCE = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i == j ? 0 : MAX_DISTANCE;

            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x - 1][y - 1] = arr[y - 1][x - 1] = 1;
        }
        br.close();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i].length; k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        int result = MAX_DISTANCE;
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            int total = 0;
            for (int j = 0; j < arr[i].length; j++) {
                total += arr[i][j];
            }
            if (result > total) {
                result = total;
                index = i + 1;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(index));
        bw.flush();
        bw.close();
    }

}