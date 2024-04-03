import java.util.*;
import java.io.*;

public class Main {

    private static int count = 0;
    private static int n;
    private static int[] arr;

    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
        } catch (IOException ignore) {
        }
        arr = generatePrimeNumberArr();
        pointer();
        try (var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(count));
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    private static int[] generatePrimeNumberArr() {
        if (n < 2) {
            return new int[0];
        }
        boolean[] isPrime = new boolean[n + 1];
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < isPrime.length; i++) {
            if (!isPrime[i]) {
                list.add(i);
            }
        }
        list.add(0);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private static void pointer() {
        int start = 0;
        int end = 0;
        int value = 0;
        while (start <= end && end < arr.length) {
            if (value > n) {
                value -= arr[start++];
            } else {
                if (value == n) {
                    count += 1;
                }
                value += arr[end++];
            }
        }
    }
}