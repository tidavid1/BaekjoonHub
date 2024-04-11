import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    private static int[] inIdx;
    private static int[] post;
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var n = Integer.parseInt(br.readLine());
            inIdx = new int[n + 1];
            post = new int[n];
            var st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                var value = Integer.parseInt(st.nextToken());
                inIdx[value] = i;
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < post.length; i++) {
                post[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException ignore) {
        }
        getPreOrder(0, inIdx.length - 1, 0, post.length - 1);
        try (var bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(STRING_BUILDER.toString());
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    private static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }
        var root = post[postEnd];
        STRING_BUILDER.append(root).append(" ");
        var inRootIndex = inIdx[root];
        var leftTreeLength = inRootIndex - inStart;

        getPreOrder(inStart, inRootIndex - 1, postStart, postStart + leftTreeLength - 1);
        getPreOrder(inRootIndex + 1, inEnd, postStart + leftTreeLength, postEnd - 1);
    }
}