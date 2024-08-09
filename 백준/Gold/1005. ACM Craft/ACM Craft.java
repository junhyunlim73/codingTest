import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, N, K;
    static int[] times;
    static ArrayList<Integer>[] adj;
    static int[] inDegree;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int t = 1; t <= T; t++) {
            Queue<Integer> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            inDegree = new int[N+1];
            adj = new ArrayList[N+1];
            times = new int[N+1];
            arr = new int[N+1];

            st = new StringTokenizer(br.readLine());

            for(int i = 1; i < N + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N+1; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adj[x].add(y);
                inDegree[y]++;
            }

            for(int i = 1; i < N+1; i++) {
                if(inDegree[i] == 0){
                    q.add(i);
                    times[i] = arr[i];
                }
            }

            while(!q.isEmpty()) {
                 int cur = q.poll();

                 for(int next : adj[cur]){
                     inDegree[next]--;
                     times[next] = Math.max(times[next], times[cur] + arr[next]);
                     if(inDegree[next] == 0)
                         q.add(next);

                 }

            }

            int w = Integer.parseInt(br.readLine());
            sb.append(times[w]).append("\n");
        }

        System.out.print(sb);
    }

}