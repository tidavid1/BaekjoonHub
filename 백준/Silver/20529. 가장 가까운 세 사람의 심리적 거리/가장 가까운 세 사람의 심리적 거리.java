import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (n > 32) {
                    sb.append(0);
                } else {
                    String[] arr = new String[n];
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = st.nextToken();
                    }
                    int min = Integer.MAX_VALUE;
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = i + 1; j < arr.length; j++) {
                            for (int k = j + 1; k < arr.length; k++) {
                                if (min == 0) {
                                    break;
                                }
                                int count = 0;
                                for (int l = 0; l < 4; l++) {
                                    count += arr[i].charAt(l) != arr[j].charAt(l) ? 1 : 0;
                                    count += arr[i].charAt(l) != arr[k].charAt(l) ? 1 : 0;
                                    count += arr[j].charAt(l) != arr[k].charAt(l) ? 1 : 0;
                                }
                                min = Math.min(count, min);
                            }
                        }
                    }
                    sb.append(min);
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