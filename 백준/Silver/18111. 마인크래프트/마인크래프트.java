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
        int b = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(arr[i][j], min);
                max = Math.max(arr[i][j], max);
            }
        }
        int time = Integer.MAX_VALUE;
        int height = 0;
        for (int i = min; i <= max; i++) {
            int count = 0;
            int block = b;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int temp = arr[j][k];
                    if (i < temp) {
                        count += (temp - i) * 2;
                        block += temp - i;
                    } else {
                        count += i - temp;
                        block -= i - temp;
                    }
                }
            }
            if (block < 0) {
                break;
            }
            if (time >= count) {
                time = count;
                height = i;
            }
        }
        bw.write(time + " " + height);
        bw.flush();
        bw.close();
        br.close();
    }

}