import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    char data;
    Node left;
    Node right;
    Node(char data) {
        this.data = data;
    }
}
class Tree {
    public Node root;
    public void createNode(char data, char left, char right) {
        if (root==null) {
            root = new Node(data);
            root.left = left != '.' ? new Node(left) : null;
            root.right = right != '.' ? new Node(right) : null;
        } else {
            searchNode(root, data, left, right);
        }
    }
    public void searchNode(Node node, char data, char left, char right) {
        if (node==null) {
            return;
        } else if(node.data == data) {
            node.left = left != '.' ? new Node(left) : null;
            node.right = right != '.' ? new Node(right) : null;
        } else {
            searchNode(node.left, data, left, right);
            searchNode(node.right, data, left, right);
        }
    }
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            if (node.left != null) preOrder(node.left);
            if (node.right != null) preOrder(node.right);
        }
    }
    public void inOrder(Node node) {
        if (node != null) {
            if (node.left != null) inOrder(node.left);
            System.out.print(node.data);
            if (node.right != null) inOrder(node.right);
        }
    }
    public void postOrder(Node node) {
        if (node != null) {
            if (node.left != null) postOrder(node.left);
            if (node.right != null) postOrder(node.right);
            System.out.print(node.data);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char data, left, right;
        Tree t = new Tree();
        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            data = st.nextToken().charAt(0);
            left = st.nextToken().charAt(0);
            right = st.nextToken().charAt(0);
            t.createNode(data, left, right);
        }
        t.preOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.postOrder(t.root);
    }
}