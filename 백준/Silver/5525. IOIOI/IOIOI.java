import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {


    public static void main(String[] args) throws IOException {
        int result = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            char[] arr = br.readLine().toCharArray();
            int count = 0;
            for (int i = 1; i < m - 1; i++) {
                if (arr[i - 1] == 'I' && arr[i] == 'O' && arr[i + 1] == 'I') {
                    count += 1;
                    if (count == n) {
                        count -= 1;
                        result += 1;
                    }
                    i += 1;
                } else {
                    count = 0;
                }
            }

        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(result));
            bw.flush();
        }
    }

}