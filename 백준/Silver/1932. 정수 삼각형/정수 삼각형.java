import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                arr[i - 1][j] += Math.max(arr[i][j], arr[i][j + 1]);
            }
        }

        System.out.println(arr[0][0]);
        br.close();
    }
}