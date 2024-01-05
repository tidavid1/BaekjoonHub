import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int number = 666;
        int count = 1;
        while (count != n) {
            number += 1;
            if (String.valueOf(number).contains("666")) {
                count += 1;
            }
        }
        bw.write(String.valueOf(number));
        bw.flush();
        bw.close();
        br.close();
    }

}