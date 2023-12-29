import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = -1;
        int idx = -1;
        for (int i = 0; i < 9; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp > max) {
                max = temp;
                idx = i + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(idx);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}