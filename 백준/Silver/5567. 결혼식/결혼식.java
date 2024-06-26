import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int cnt;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];

        for(int i = 1; i < N + 1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[v].add(e);
            adj[e].add(v);
        }

        visited[1] = true;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int d : adj[1]){
            stack.push(d);
            visited[d] = true;
        }

        cnt += stack.size();

        while(!stack.isEmpty()){
            int n = stack.poll();

            for(int d : adj[n]){
                if(!visited[d]){
                    cnt++;
                    visited[d] = true;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }

}