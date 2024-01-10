import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int gcd = gcd(n, m);
        int acm = n * m / gcd;
        sb.append(gcd).append("\n").append(acm);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int n, int m) {
        return m == 0 ? n : gcd(m, n % m);
    }
}