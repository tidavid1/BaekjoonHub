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
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                Map<String, Integer> map = new HashMap<>();
                int n = Integer.parseInt(br.readLine());
                while (n-- > 0) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    st.nextToken();
                    String category = st.nextToken();
                    map.put(category, map.getOrDefault(category, 0) + 1);
                }
                int result = 1;
                for (int value : map.values()) {
                    result *= value + 1;
                }
                sb.append(result - 1).append("\n");
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(sb.toString());
            bw.flush();
        }
    }


}