import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    private static final int[] OPERATORS = new int[4];

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < OPERATORS.length; i++) {
                OPERATORS[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException ignore) {
        }
        dfs(1, arr[0]);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(max));
            bw.newLine();
            bw.write(String.valueOf(min));
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    public static void dfs(int depth, int value) {
        if (depth == arr.length) {
            max = Math.max(value, max);
            min = Math.min(value, min);
            return;
        }

        for (int i = 0; i < OPERATORS.length; i++) {
            int result = value;
            if (OPERATORS[i] > 0) {
                OPERATORS[i] -= 1;
                switch (i) {
                    case 0:
                        result += arr[depth];
                        break;
                    case 1:
                        result -= arr[depth];
                        break;
                    case 2:
                        result *= arr[depth];
                        break;
                    default:
                        result /= arr[depth];
                        break;
                }
                dfs(depth + 1, result);
                OPERATORS[i] += 1;
            }
        }

    }

}