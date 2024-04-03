import java.util.*;
import java.io.*;

public class Main {

    private static int max = Integer.MIN_VALUE;
    private static int m;
    private static int[] arr;

    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException ignore) {
        }
        pointer();
        try (var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(max));
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    private static void pointer() {
        int start = 0;
        int end = start + m;
        int value = 0;
        for (int i = 0; i < end; i++) {
            value += arr[i];
        }
        max = Math.max(value, max);
        while (end < arr.length) {
            value -= arr[start++];
            value += arr[end++];
            max = Math.max(value, max);
        }
    }
}