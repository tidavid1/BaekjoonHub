import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final int MAX_LENGTH = 101;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                long[] arr = new long[MAX_LENGTH];
                arr[1] = 1;
                arr[2] = 1;
                arr[3] = 1;
                for (int i = 4; i <= n; i++) {
                    arr[i] = arr[i - 3] + arr[i - 2];
                }
                sb.append(arr[n]).append("\n");
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(sb.toString());
            bw.flush();
        }
    }


}