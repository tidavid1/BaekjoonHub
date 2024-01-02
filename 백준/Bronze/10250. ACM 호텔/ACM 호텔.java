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
        int number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            if (n % h == 0) {
                bw.write(String.valueOf((h * 100) + (n / h)));
            } else {
                bw.write(String.valueOf(((n % h) * 100) + ((n / h) + 1)));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

}