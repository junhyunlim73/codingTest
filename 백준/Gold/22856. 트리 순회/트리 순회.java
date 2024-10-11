import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    static Node[] trees;
    static int N;
    static int lastNode;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        trees = new Node[N+1];

        for(int i = 1; i < N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            trees[root] = new Node(root, left, right);
        }

        inOrder(trees[1]);
        similarInOrder(trees[1]);

    }

    private static void inOrder(Node root){
        if(root.left != -1){
            inOrder(trees[root.left]);
        }
        lastNode = root.value;
        if(root.right != -1){
            inOrder(trees[root.right]);
        }
    }

    private static void similarInOrder(Node root){
        if(root.left != -1){
            cnt++;
            similarInOrder(trees[root.left]);
            cnt++;
        }

        if(root.value == lastNode){
            System.out.println(cnt);
            exit(0);
        }

        if(root.right != -1){
            cnt++;
            similarInOrder(trees[root.right]);
            cnt++;
        }
    }


    static class Node{
        int value, left, right;

        public Node(int value, int left, int right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

}