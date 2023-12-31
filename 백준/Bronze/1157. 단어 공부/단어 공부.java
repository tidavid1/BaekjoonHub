import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[26];
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                arr[s.charAt(i) - 'A'] += 1;
            } else {
                arr[s.charAt(i) - 'a'] += 1;
            }
        }
        int max = -1;
        char word = '?';

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                word = (char) (i + 65);
            } else if (arr[i] == max) {
                word = '?';
            }
        }
        bw.write(word);
        bw.flush();
        bw.close();
        br.close();
    }

}