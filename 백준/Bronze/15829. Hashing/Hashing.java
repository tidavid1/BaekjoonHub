import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final int MOD_NUMBER = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long result = 0;
        long pow = 1;
        for (int i = 0; i < n; i++) {
            result += (s.charAt(i) - '`') * pow % MOD_NUMBER;
            pow = pow * 31 % MOD_NUMBER;
        }
        result %= MOD_NUMBER;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

}