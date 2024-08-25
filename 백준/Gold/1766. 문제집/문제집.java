import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] inDegree;
    static ArrayList<Integer>[] adj;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        inDegree = new int[N+1];

        for(int i = 0; i < N + 1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            inDegree[b]++;
        }

        PriorityQueue<Integer> p = new PriorityQueue<>();

        for(int i = 1; i < N+1; i++){
            if(inDegree[i] == 0){
                p.add(i);
            }
        }

        while(!p.isEmpty()){
            int cur = p.poll();
            sb.append(cur + " ");

            for(int next : adj[cur]){
                inDegree[next]--;

                if(inDegree[next] == 0){
                    p.add(next);
                }

            }

        }

        System.out.println(sb);
        br.close();
    }

}