import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static long[] cnts;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long max = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        cnts = new long[N + 1];

        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[b].add(a);
        }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;

            while (!q.isEmpty()) {
                int cur = q.poll();

                for(int d : adj[cur]) {
                    if(!visited[d]) {
                        q.add(d);
                        cnts[i]++;
                        visited[d] = true;
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            max = Math.max(max, cnts[i]);
        }

        for(int i = 1; i <= N; i++) {
            if(max == cnts[i]) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }

}