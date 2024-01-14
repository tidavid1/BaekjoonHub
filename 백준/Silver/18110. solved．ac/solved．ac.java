import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] arr = new int[n];
        int intercept = (int) Math.round(n * .15);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = intercept; i < arr.length - intercept; i++) {
            sum += arr[i];
        }
        bw.write(String.valueOf(Math.round((double) sum / (n - 2 * intercept))));
        bw.flush();
        bw.close();
        br.close();
    }

}