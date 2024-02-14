import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static long start;
    private static long end;

    public static void main(String[] args) {
        int answer = 1;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = Long.parseLong(st.nextToken());
            end = Long.parseLong(st.nextToken());
        } catch (IOException ignore) {
        }
        while (end != start) {
            if ((end < start) || (end % 10 != 1 && end % 2 != 0)) {
                answer = -1;
                break;
            }
            if (end % 2 == 0) {
                end /= 2;
            } else {
                end /= 10;
            }
            answer += 1;
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(answer));
            bw.flush();
        } catch (IOException ignore) {
        }
    }


}