import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.readLine();
        int[] find = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        Arrays.sort(arr);
        for (int i : find) {
            if (Arrays.binarySearch(arr, i) >= 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}