import java.util.*;
import java.io.*;

public class Main {


    private static int min = Integer.MAX_VALUE;
    private static int[] arr;
    private static final int[] RESULT = new int[2];

    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var n = Integer.parseInt(br.readLine());
            arr = new int[n];
            var st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException ignore) {

        }
        Arrays.sort(arr);
        pointer();
        try (var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(RESULT[0]));
            bw.write(" ");
            bw.write(String.valueOf(RESULT[1]));
            bw.flush();
        } catch (IOException ignore) {

        }
    }

    private static void pointer() {
        int start = 0;
        int end = arr.length - 1;
        int value = arr[end] + arr[start];
        while (start < end) {
            validateResult(value, start, end);
            if (value == 0) {
                break;
            } else if (value > 0) {
                value -= arr[end--];
                value += arr[end];
            } else {
                value -= arr[start++];
                value += arr[start];
            }
        }
    }

    private static void validateResult(int value, int start, int end) {
        value = Math.abs(value);
        if (value < min) {
            min = value;
            RESULT[0] = arr[start];
            RESULT[1] = arr[end];
        }
    }
}