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
        StringTokenizer st = new StringTokenizer(br.readLine());
        double answer = 0;
        while (st.hasMoreTokens()) {
            answer += Math.pow(Integer.parseInt(st.nextToken()), 2);
        }
        bw.write(String.valueOf((int) answer % 10));
        bw.flush();
        bw.close();
        br.close();
    }

}