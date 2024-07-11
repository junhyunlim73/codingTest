import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, X;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dis = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[v].add(e);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(X);
        visited[X] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for(int d : adj[now]) {
                if(!visited[d]) {
                    visited[d] = true;
                    dis[d] = dis[now] + 1;
                    q.add(d);
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            if(dis[i] == K){
                sb.append(i).append("\n");
            }
        }

        System.out.println(!sb.toString().equals("") ? sb.toString() : "-1");
        br.close();
    }

}