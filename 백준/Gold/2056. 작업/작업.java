import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] times;
    static int[] dp;
    static int N;
    static int[] inDegree;
    static ArrayList<Integer>[] adj;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new int[N + 1];
        dp = new int[N + 1];
        inDegree = new int[N + 1];
        adj = new ArrayList[N + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            for(int j = 0; j < count; j++) {
                int idx = Integer.parseInt(st.nextToken());
                inDegree[i]++;
                adj[idx].add(i);
            }
        }

        for(int i = 1; i < N + 1; i++) {
            if(inDegree[i] == 0) {
                total = Math.max(times[i], total);
                dp[i] = times[i];
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            total = Math.max(total, dp[cur]);

            for(int next : adj[cur]){
                dp[next] = Math.max(dp[cur] + times[next], dp[next]);
                if(--inDegree[next] == 0){
                    q.add(next);
                }
            }
        }

        System.out.println(total);

    }
}