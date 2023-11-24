import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n <= 5) {
            if (n == 4) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
            return;
        }
        int[] table = new int[n + 1];
        table[3] = 1;
        table[5] = 1;
        for (int i = 6; i <= n; i++) {
            if (table[i - 3] == 0 && table[i - 5] == 0) {
                table[i] = 0;
            } else {
                table[i] = Math.min(table[i - 3] + 1 == 1 ? Integer.MAX_VALUE : table[i - 3] + 1, table[i - 5] + 1 == 1 ? Integer.MAX_VALUE : table[i - 5] + 1);
            }
        }

        System.out.println(table[n] == 0 ? -1 : table[n]);
        br.close();
    }
}