import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long) ((s.charAt(i) - '`') * Math.pow(31, i) % 1234567891);
        }
        bw.write(String.valueOf(result % 1234567891));
        bw.flush();
        bw.close();
        br.close();
    }

}