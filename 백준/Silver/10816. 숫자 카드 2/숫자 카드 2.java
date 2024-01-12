import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        br.readLine();
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        br.readLine();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}