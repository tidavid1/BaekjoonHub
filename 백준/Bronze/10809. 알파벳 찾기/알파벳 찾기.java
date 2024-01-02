import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        String word = br.readLine();
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (arr[index] == -1) {
                arr[index] = i;
            }
        }
        for(int i: arr) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}