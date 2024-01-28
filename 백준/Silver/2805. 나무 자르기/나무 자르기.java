import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int min = 0;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        int m;
        int[] arr;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
        }

        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for (int i : arr) {
                if (i - mid > 0) {
                    sum += i - mid;
                }
            }
            if (sum < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(min - 1));
            bw.flush();
        }
    }

}