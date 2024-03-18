import java.io.*;
import java.util.*;

public class Main {
    
    private static final int[][] DIRECTION = {
        {},
        {1},
        {1, 3},
        {0, 1},
        {0, 1, 3},
        {0, 1, 2, 3}
    };

    private static int[][] cctv = new int[8][];
    private static int answer = 64;
    private static int n;
    private static int m;
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            int cctvCount = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    arr[i][j] = value;
                    if (value > 0 && value <= 5) {
                        cctv[cctvCount++] = new int[]{value, i, j};
                    }
                }
            }
            dfs(0, arr);
        } catch (IOException ignore) {

        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(answer));
            bw.flush();
        } catch (IOException ignore) {

        }
    }

    private static void dfs(int depth, int[][] arr) {
        if (depth >= cctv.length || cctv[depth] == null) {
            int result = calculateSpace(arr);
            answer = Math.min(result, answer);
            return;
        }
        int number = cctv[depth][0];
        int cctvX = cctv[depth][1];
        int cctvY = cctv[depth][2];
        for (int i = 0; i < 4; i++) {
            int[][] arrCopy = new int[n][m];
            for (int j = 0; j < n; j++) {
                if (m >= 0)
                    System.arraycopy(arr[j], 0, arrCopy[j], 0, m);
            }
            for (int direction : DIRECTION[number]) {
                direction = (direction + i) % 4;
                switch (direction) {
                    case 1:
                        moveWidth(cctvX, cctvY, arrCopy, true);
                        break;
                    case 2:
                        moveHeight(cctvX, cctvY, arrCopy, true);
                        break;
                    case 3:
                        moveWidth(cctvX, cctvY, arrCopy, false);
                        break;
                    default:
                        moveHeight(cctvX, cctvY, arrCopy, false);
                }
            }
            dfs(depth + 1, arrCopy);
        }
    }


    private static void moveWidth(int x, int y, int[][] arr, boolean flag) {
        int direction = flag ? 1 : -1;
        while (0 <= x + direction && x + direction < arr.length) {
            x += direction;
            if (arr[x][y] == 6) {
                break;
            } else if (arr[x][y] != 0) {
                continue;
            }
            arr[x][y] = -1;
        }
    }

    private static void moveHeight(int x, int y, int[][] arr, boolean flag) {
        int direction = flag ? 1 : -1;
        while (0 <= y + direction && y + direction < arr[x].length) {
            y += direction;
            if (arr[x][y] == 6) {
                break;
            } else if (arr[x][y] != 0) {
                continue;
            }
            arr[x][y] = -1;
        }
    }

    private static int calculateSpace(int[][] arr) {
        int result = 0;
        for (int[] arr1 : arr) {
            for (int i : arr1) {
                if (i == 0) {
                    result += 1;
                }
            }
        }
        return result;
    }
}