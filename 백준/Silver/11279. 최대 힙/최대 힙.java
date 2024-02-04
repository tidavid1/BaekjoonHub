import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0){
                int command = Integer.parseInt(br.readLine());
                if(command == 0){
                    if(queue.isEmpty()){
                        sb.append(0);
                    }else{
                        sb.append(queue.poll());
                    }
                    sb.append("\n");
                }else {
                    queue.add(command);
                }
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(sb.toString());
            bw.flush();
        }
    }

}