import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] table = new int[n + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[n] = 0;
        for (int i = n; i > 1; i--) {
            if (i % 3 == 0) {
                table[i / 3] = Math.min(table[i] + 1, table[i / 3]);
            }
            if (i % 2 == 0) {
                table[i / 2] = Math.min(table[i] + 1, table[i / 2]);
            }
            table[i - 1] = Math.min(table[i] + 1, table[i - 1]);
        }
        System.out.println(table[1]);
    }
}