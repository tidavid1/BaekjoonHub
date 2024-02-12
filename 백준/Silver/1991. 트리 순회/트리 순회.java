import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static final Map<Character, Node> TREE = new HashMap<>();
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static Node root;

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char parent = st.nextToken().charAt(0);
                char left = st.nextToken().charAt(0);
                char right = st.nextToken().charAt(0);
                if (parent == 'A') {
                    root = new Node(parent);
                    TREE.put(parent, root);
                }
                Node node = TREE.get(parent);
                if (left != '.') {
                    Node temp = TREE.getOrDefault(left, new Node(left));
                    node.left = temp;
                    if (!TREE.containsKey(left)) {
                        TREE.put(left, temp);
                    }

                }
                if (right != '.') {
                    Node temp = TREE.getOrDefault(right, new Node(right));
                    node.right = temp;
                    if (!TREE.containsKey(right)) {
                        TREE.put(right, temp);
                    }
                }
            }
        } catch (IOException ignore) {
        }
        preOrder(root);
        STRING_BUILDER.append("\n");
        inOrder(root);
        STRING_BUILDER.append("\n");
        postOrder(root);
        STRING_BUILDER.append("\n");
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(STRING_BUILDER.toString());
            bw.flush();
        } catch (IOException ignore) {
        }
    }

    static class Node {

        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }

    private static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        STRING_BUILDER.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        STRING_BUILDER.append(node.value);
        inOrder(node.right);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        STRING_BUILDER.append(node.value);
    }
}