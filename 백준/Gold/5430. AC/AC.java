import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                char[] commands = br.readLine().toCharArray();
                int m = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
                Deque<Integer> deque = new LinkedList<>();
                for (int j = 0; j < m; j++) {
                    deque.add(Integer.parseInt(st.nextToken()));
                }

                boolean flag = true;
                boolean errorFlag = false;
                for (char command : commands) {
                    if (command == 'R') {
                        flag = !flag;
                        continue;
                    }
                    if (flag) {
                        if (deque.pollFirst() == null) {
                            sb.append("error").append("\n");
                            errorFlag = true;
                            break;
                        }
                    } else {
                        if (deque.pollLast() == null) {
                            sb.append("error").append("\n");
                            errorFlag = true;
                            break;
                        }
                    }
                }
                if(errorFlag){
                    continue;
                }
                sb.append("[");
                if (!deque.isEmpty()) {
                    if(flag){
                        sb.append(deque.pollFirst());
                        while(!deque.isEmpty()){
                            sb.append(",").append(deque.pollFirst());
                        }
                    }else{
                        sb.append(deque.pollLast());
                        while(!deque.isEmpty()){
                            sb.append(",").append(deque.pollLast());
                        }
                    }
                }
                sb.append("]").append("\n");
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(sb.toString());
            bw.flush();
        }
    }

}