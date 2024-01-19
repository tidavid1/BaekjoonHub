import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add": {
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "remove": {
                    int temp = Integer.parseInt(st.nextToken());
                    set.remove(temp);
                    break;
                }
                case "check": {
                    sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
                    break;
                }
                case "toggle": {
                    int temp = Integer.parseInt(st.nextToken());
                    if (set.contains(temp)) {
                        set.remove(temp);
                    } else {
                        set.add(temp);
                    }
                    break;
                }
                case "all": {
                    IntStream.rangeClosed(1, 20).forEach(set::add);
                    break;
                }
                default: {
                    set.clear();
                }
            }
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}