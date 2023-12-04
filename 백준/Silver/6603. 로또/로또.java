import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] numbers = br.readLine().split(" ");
            int k = Integer.parseInt(numbers[0]);
            if (k == 0) {
                break;
            }
            int[] s = new int[k];
            boolean[] visited = new boolean[k];
            for (int i = 1; i < numbers.length; i++) {
                s[i - 1] = Integer.parseInt(numbers[i]);
            }
            DFS(0, 0, s, visited);
            System.out.println();
        }
        br.close();
    }

    private static void DFS(int depth, int start, int[] arr, boolean[] visited) {
        if (depth == 6) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(visited[i] ? String.format("%d ", arr[i]) : "");
            }
            System.out.println();
        }
        for (int i = start; i < visited.length; i++) {
            visited[i] = true;
            DFS(depth + 1, i + 1, arr, visited);
            visited[i] = false;
        }
    }
}
