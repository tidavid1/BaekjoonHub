import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final int DEFAULT_CHANNEL = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int channel = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        br.close();
        
        int result = Math.abs(channel - DEFAULT_CHANNEL);
        for (int i = 0; i < 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (broken[str.charAt(j) - '0']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                int min = Math.abs(channel - i) + len;
                result = Math.min(min, result);
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
    
}