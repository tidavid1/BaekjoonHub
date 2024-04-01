import java.util.*;
import java.io.*;

public class Main {

    private static int min = Integer.MAX_VALUE;
    private static int m;

    private static boolean[] visited;

    private static final List<Node> HOUSES = new ArrayList<>();
    private static final List<Node> CHICKENS = new ArrayList<>();

    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            for (var i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (var j = 1; j <= n; j++) {
                    var value = Integer.parseInt(st.nextToken());
                    if(value == 1){
                        HOUSES.add(new Node(i, j));
                    } else if(value == 2){
                        CHICKENS.add(new Node(i, j));
                    }
                }
            }

            visited = new boolean[CHICKENS.size()];
        } catch (IOException ignore) {
        }
        dfs(0, 0);
        try (var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(min));
            bw.flush();
        } catch (IOException ignore) {
        }

    }

    private static class Node {

        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void dfs(int idx, int depth) {
        if (depth == m) {
            int result = 0;
            for (var house : HOUSES) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < CHICKENS.size(); j++) {
                    if (visited[j]) {
                        var chicken = CHICKENS.get(j);
                        temp = Math.min(
                            Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y), temp);
                    }
                }
                result += temp;
            }
            min = Math.min(result, min);
            return;
        }
        for (int i = idx; i < CHICKENS.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i+1, depth + 1);
                visited[i] = false;
            }
        }
    }

}