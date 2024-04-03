import java.util.*;
import java.io.*;

public class Main {

    private static int count = 0;
    private static int m;
    private static int[] arr;

    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            var st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            m = Integer.parseInt(br.readLine());
        } catch (IOException ignore) {
        }
        pointer();
        try (var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(count));
            bw.flush();
        } catch (IOException ignore) {
        }

    }

    private static void pointer() {
        int start = 0;
        int end = arr.length - 1;
        int value = arr[start] + arr[end];
        while (start < end) {
            if (value > m) {
                value -= arr[end--];
                value += arr[end];
            } else {
                if (value == m) {
                    count += 1;
                }
                value -= arr[start++];
                value += arr[start];
            }
        }
    }
}