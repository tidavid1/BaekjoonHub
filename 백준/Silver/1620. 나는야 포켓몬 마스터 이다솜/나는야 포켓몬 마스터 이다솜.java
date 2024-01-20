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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> idxMap = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            String temp = br.readLine();
            nameMap.put(temp, i);
            idxMap.put(i, temp);
        }
        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            if (temp.matches("\\d+")) {
                sb.append(idxMap.get(Integer.parseInt(temp)));
            } else {
                sb.append(nameMap.get(temp));
            }
            sb.append("\n");
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}