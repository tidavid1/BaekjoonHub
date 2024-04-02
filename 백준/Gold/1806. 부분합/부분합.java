import java.util.*;
import java.io.*;

public class Main {

    private static int min = Integer.MAX_VALUE;
    private static int m;
    private static int[] arr;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            var st = new StringTokenizer(br.readLine());
            var n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException ignore) {
        }
        pointer();
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(min));
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    private static void pointer() {
        int start = 0;
        int end = 0;
        int sum = 0;
        while (start <= end && end <= arr.length -1 ) {
            if (sum < m) {
                sum += arr[end++];
            } else {
                min = Math.min(min, end - start);
                sum -= arr[start++];
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
    }

}