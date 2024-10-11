import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[] leftNode;
    static char[] rightNode;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        leftNode = new char[N];
        rightNode = new char[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            leftNode[root - 'A'] = left;
            rightNode[root - 'A'] = right;
        }

        preOrder('A');
        bw.write("\n");
        inOrder('A');
        bw.write("\n");
        postOrder('A');
        bw.flush();
        bw.close();
        br.close();
    }

    private static void preOrder(char value) throws IOException {
        bw.write(value);
        if(leftNode[value - 'A'] != '.') {
            preOrder(leftNode[value - 'A']);
        }
        if(rightNode[value - 'A'] != '.')
            preOrder(rightNode[value - 'A']);
    }

    private static void inOrder(char value) throws IOException {
        if(leftNode[value - 'A'] != '.') {
            inOrder(leftNode[value - 'A']);
        }
        bw.write(value);
        if(rightNode[value - 'A'] != '.')
            inOrder(rightNode[value - 'A']);
    }

    private static void postOrder(char value) throws IOException {
        if(leftNode[value - 'A'] != '.') {
            postOrder(leftNode[value - 'A']);
        }
        if(rightNode[value - 'A'] != '.')
            postOrder(rightNode[value - 'A']);
        bw.write(value);
    }

}