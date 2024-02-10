import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[] arr;
    private static int[] table;
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);
        } catch (IOException ignore) {
        }
        table = new int[m];
        dfs(0, 0);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(STRING_BUILDER.toString());
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    private static void dfs(int location, int depth) {
        if (depth == m) {
            for (int i : table) {
                STRING_BUILDER.append(i).append(" ");
            }
            STRING_BUILDER.append("\n");
            return;
        }
        for (int i = location; i < n; i++) {
            table[depth] = arr[i];
            dfs(i, depth + 1);
        }
    }
}