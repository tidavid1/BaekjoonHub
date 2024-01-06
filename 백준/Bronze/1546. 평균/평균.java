import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        float sum = 0;
        int[] arr = new int[n];
        int idx = 0;
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            arr[idx] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[idx], max);
            idx += 1;
        }
        for(int i : arr){
            sum += (float) i / max * 100;
        }
        bw.write(String.valueOf(sum / n));
        bw.flush();
        bw.close();
        br.close();
    }

}