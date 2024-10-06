import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node root = new Node(n);

        while(true){
            String input = br.readLine();

            if(input == null || input.equals(""))
                break;

            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
        br.close();
    }

    private static void postOrder(Node root){
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.num);
    }

    static class Node{
        int num;
        Node right, left;

        public Node(int num){
            this.num = num;
        }

        public void insert(int n){
            if(n < this.num){
                if(this.left == null){
                    this.left = new Node(n);
                }else
                    this.left.insert(n);
            }else if(this.num < n){
                if(this.right == null){
                    this.right = new Node(n);
                }else
                    this.right.insert(n);
            }
        }
    }
}