import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int DICE_NUMBER = 6;
    private static final int INIT_NUMBER = 101;
    private static final int MAX_LENGTH = 101;
    private static final int[] BOARD;
    private static final Map<Integer, Integer> SHORT_CUT = new HashMap<>();
    private static final Queue<Integer> QUEUE = new LinkedList<>();

    static {
        BOARD = new int[MAX_LENGTH];
        Arrays.fill(BOARD, INIT_NUMBER);
        BOARD[1] = 0;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n + m; i++) {
                st = new StringTokenizer(br.readLine());
                SHORT_CUT.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }
        QUEUE.add(1);
        while (BOARD[MAX_LENGTH - 1] == INIT_NUMBER && !QUEUE.isEmpty()) {
            bfs();
        }
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(BOARD[MAX_LENGTH - 1]));
            bw.flush();
        }
    }


    private static void bfs() {
        int size = QUEUE.size();
        for (int i = 0; i < size; i++) {
            int index = QUEUE.poll();
            for (int j = 1; j <= DICE_NUMBER; j++) {
                if (index + j < MAX_LENGTH && BOARD[index + j] == INIT_NUMBER) {
                    BOARD[index + j] = BOARD[index] + 1;
                    int target = SHORT_CUT.getOrDefault(index + j, 0);
                    if (target != 0) {
                        BOARD[target] = Math.min(BOARD[index] + 1, BOARD[target]);
                        QUEUE.add(target);
                    } else {
                        QUEUE.add(index + j);
                    }
                }
            }
        }
    }
}