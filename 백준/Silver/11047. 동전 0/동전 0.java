
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int money : arr) {
            result += price / money;
            price %= money;
            if (price == 0) {
                break;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}