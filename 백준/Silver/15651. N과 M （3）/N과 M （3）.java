import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int m;
    private static int[] arr;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[m];
        } catch (IOException ignore) {
        }
        dfs(0);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }

    }

}