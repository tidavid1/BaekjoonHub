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
        int num = Integer.parseInt(st.nextToken());
        boolean flag = num == 1 || num == 8;
        do {
            int temp = Integer.parseInt(st.nextToken());
            if (flag) {
                flag = temp - 1 == num || temp + 1 == num;
                num = temp;
            }
        } while (st.hasMoreTokens());
        bw.write(!flag ? "mixed" : num == 8 ? "ascending" : "descending");
        bw.flush();
        bw.close();
        br.close();
    }

}