import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                SortedMap<Integer, Integer> map = new TreeMap<>();
                int k = Integer.parseInt(br.readLine());
                for (int j = 0; j < k; j++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    String command = st.nextToken();
                    int value = Integer.parseInt(st.nextToken());
                    if (command.equals("I")) {
                        map.put(value, map.getOrDefault(value, 0) + 1);
                    } else if (!map.isEmpty()) {
                        int key = value == 1 ? map.lastKey() : map.firstKey();
                        if (map.get(key) == 1) {
                            map.remove(key);
                        } else {
                            map.put(key, map.get(key) - 1);
                        }
                    }
                }
                if (map.isEmpty()) {
                    sb.append("EMPTY");
                } else {
                    sb.append(map.lastKey()).append(" ").append(map.firstKey());
                }
                sb.append("\n");
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(sb.toString());
            bw.flush();
        }
    }


}