import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;
    static int[] arr;
    static int[] inDegree;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        arr = new int[N+1];
        adj = new ArrayList[N+1];
        inDegree = new int[N+1];

        for(int i = 0; i < N+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;

            while(true){
                int index = Integer.parseInt(st.nextToken());

                if(index == -1) break;

                inDegree[i]++;
                adj[index].add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
                dp[i] = arr[i];
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int v : adj[cur]) {
                inDegree[v]--;
                dp[v] = Math.max(dp[v], dp[cur] + arr[v]);
                if(inDegree[v] == 0) q.offer(v);
            }

        }

        for(int i = 1; i <= N; i++) {
            System.out.println(dp[i]);
        }
        br.close();

    }

}