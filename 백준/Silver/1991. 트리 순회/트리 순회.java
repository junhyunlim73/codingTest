import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static String[] right;
    static String[] left;
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        right = new String[N];
        left = new String[N];
        
        for(int i = 0; i < N; i++){
            String[] node = br.readLine().split(" ");
            map.put(node[0], i);
            left[i] = node[1];
            right[i] = node[2];
        }

        preOrder("A");
        System.out.println();
        inOrder("A");
        System.out.println();
        postOrder("A");
        br.close();
    }

    static void preOrder(String cur){
        if(cur.equals(".")){
            return;
        }

        int idx = map.get(cur);
        System.out.print(cur);
        preOrder(left[idx]);
        preOrder(right[idx]);
    }

    static void inOrder(String cur){
        if(cur.equals(".")){
            return;
        }

        int idx = map.get(cur);
        inOrder(left[idx]);
        System.out.print(cur);
        inOrder(right[idx]);
    }

    static void postOrder(String cur){
        if(cur.equals(".")){
            return;
        }

        int idx = map.get(cur);
        postOrder(left[idx]);
        postOrder(right[idx]);
        System.out.print(cur);
    }
}