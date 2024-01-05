import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String s = br.readLine();
            boolean flag = true;
            if (s.equals("0")) {
                break;
            }
            for (int i = 0; i < s.length() / 2; i++) {
                flag = flag && (s.charAt(i) == s.charAt(s.length() - 1 - i));
            }
            if (flag) {
                bw.write("yes");
            } else {
                bw.write("no");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

}