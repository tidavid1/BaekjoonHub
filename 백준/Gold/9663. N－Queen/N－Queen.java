import java.io.*;


public class Main {

    private static int n;
    private static int result = 0;
    private static int[] arr;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
        } catch (IOException ignore) {
        }
        dfs(0);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(result));
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    public static void dfs(int depth) {
        if (depth == n) {
            result += 1;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (verifyQueen(depth)) {
                dfs(depth + 1);
            }
        }

    }


    private static boolean verifyQueen(int value) {
        for (int i = 0; i < value; i++) {
            if (arr[value] == arr[i]) {
                return false;
            }
            if (Math.abs(value - i) == Math.abs(arr[value] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}