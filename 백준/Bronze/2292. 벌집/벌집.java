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
        int result = 1;
        int count = 2;
        if (n != 1) {
            while (count <= n) {
                count += 6 * result;
                result += 1;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}