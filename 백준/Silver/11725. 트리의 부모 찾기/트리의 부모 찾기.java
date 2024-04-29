import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] node;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        node = new int[N + 1];
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];

        for(int i = 1; i < N + 1; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[v].add(e);
            tree[e].add(v);
        }

        Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(1));
        while (!queue.isEmpty()){
            int now = queue.poll();
            visited[now] = true;

            for(int d : tree[now]){
                if(!visited[d]){
                    node[d] = now;
                    queue.add(d);
                }
            }
        }

        for(int i = 2; i < N+1; i++){
            bw.write(node[i] + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}