import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static int[] node;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        visited = new boolean[N+1];
        node = new int[N+1];

        for(int i = 1; i < N + 1; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[v].add(e);
            tree[e].add(v);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        while(!queue.isEmpty()){
            int cur = queue.remove();
            visited[cur] = true;

            for(int d : tree[cur]){
                if(!visited[d]){
                    node[d] = cur;
                    queue.add(d);
                }
            }
        }

        for(int i = 2; i < N+1; i++){
            System.out.println(node[i]);
        }

        br.close();
    }
}