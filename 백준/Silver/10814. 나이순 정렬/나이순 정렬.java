import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Queue<Info> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Info(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Info implements Comparable<Info> {

        private final int age;
        private final String name;
        private final int index;

        public Info(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        @Override
        public int compareTo(Info o) {
            if (this.age < o.age) {
                return -1;
            } else if (this.age > o.age) {
                return 1;
            } else {
                return this.index - o.index;
            }
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}