import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        boolean[] verify = new boolean[10001];
        for (int i = 1; i < verify.length; i++) {
            int n = findNumber(i);
            if (n <= 10000) {
                verify[n] = true;
            }
        }
        for (int i = 1; i < verify.length; i++) {
            if (!verify[i]) {
                sb.append(i).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int findNumber(int n) {
        int result = n;
        while (n != 0) {
            result += (n % 10);
            n /= 10;
        }
        return result;
    }
}