import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static int[] adj;
    static boolean[] visited;
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        adj = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++){
            int n = Integer.parseInt(br.readLine());
            adj[i] = n;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, i);
                visited[i] = false;
            }
        }

        bw.write(pq.size() + "\n");

        while(!pq.isEmpty()){
            bw.write(pq.poll() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start, int target){
        int next = adj[start];

        if(!visited[next]){
            visited[next] = true;
            dfs(next, target);
            visited[next] = false;
        }

        if(next == target)
            pq.add(target);
    }

}