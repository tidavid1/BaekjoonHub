import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputValues = br.readLine().split(" ");
        int n = Integer.parseInt(inputValues[0]);
        long m = Long.parseLong(inputValues[1]);
        long max = Long.MIN_VALUE;
        long[] timeTable = new long[n];
        for (int i = 0; i < n; i++) {
            timeTable[i] = Long.parseLong(br.readLine());
            max = Math.max(timeTable[i], max);
        }
        long result = binarySearch(m, max, timeTable);
        System.out.println(result);
    }

    private static long binarySearch(long m, long max, long[] timeTable) {
        long left = 0;
        long right = m * max;
        while(left <= right){
            long mid = (left+right) / 2;
            long count = 0;
            for(long time:timeTable){
                count += mid/time;
                if(count >= m){
                    break;
                }
            }
            if (count < m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}