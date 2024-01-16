import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {


    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);
        move(size, r, c);
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }


    private static void move(int size, int r, int c) {
        if (size == 1) {
            return;
        }
        if (r < size / 2) {
            if (c < size / 2) {
                move(size / 2, r, c);
            } else {
                count += size * size / 4;
                move(size / 2, r, c - size / 2);
            }
        } else {
            if (c < size / 2) {
                count += (size * size / 4) * 2;
                move(size / 2, r - size / 2, c);
            } else {
                count += (size * size / 4) * 3;
                move(size / 2, r - size / 2, c - size / 2);
            }
        }

    }

}