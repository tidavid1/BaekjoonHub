import java.util.*;
import java.io.*;

public class Main {

    private static final int MOD = 1000;
    private static int[][] arr;
    private static int n;
    private static long m;

    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Long.parseLong(st.nextToken());
            arr = new int[n][n];
            for (int i = 0; i < arr.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < arr[i].length; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    arr[i][j] = value % MOD;
                }
            }
        } catch (IOException ignore) {
        }
        int[][] result = pow(arr, m);
        try (var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int[] arr : result) {
                for (int i : arr) {
                    bw.write(String.valueOf(i));
                    bw.write(" ");
                }
                bw.newLine();
            }
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    private static int[][] pow(int[][] arr1, long exp) {
        if (exp == 1L) {
            return arr1;
        }
        int[][] result = pow(arr1, exp / 2);
        result = mul(result, result);
        if (exp % 2 != 0) {
            result = mul(result, arr);
        }
        return result;
    }

    private static int[][] mul(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr1.length];
        int r;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r = arr1[j][i];
                for (int k = 0; k < n; k++) {
                    result[j][k] += r * arr2[i][k];
                    result[j][k] %= MOD;
                }
            }
        }
        return result;
    }
}