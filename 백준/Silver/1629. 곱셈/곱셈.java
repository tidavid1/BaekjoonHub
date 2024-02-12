import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static long a;
    private static long b;
    private static long mod;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            mod = Long.parseLong(st.nextToken());
        } catch (IOException ignore) {
        }
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(pow(a, b)));
            bw.flush();
        } catch (IOException ignore) {

        }
    }

    private static long pow(long a, long b) {
        if (b == 1) {
            return a % mod;
        }
        long temp = pow(a, b / 2);
        if (b % 2 == 1) {
            return (temp * temp % mod) * a % mod;
        }
        return temp * temp % mod;
    }
}