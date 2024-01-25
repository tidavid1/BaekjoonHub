import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        br.close();
        for (int i = 0; i < arr.length; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            set.add(temp);
        }
        Queue<Integer> pq = new PriorityQueue<>(set);
        int idx = 0;
        while (!pq.isEmpty()) {
            map.put(pq.poll(), idx++);
        }
        for (int i = 0; i < arr.length; i++) {
            answer[i] = map.get(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}