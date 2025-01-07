import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] adj;
    static int[] inDegree;
    static int[] times;
    static int N, M, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        inDegree = new int[N+1];
        times = new int[N+1];
        adj = new ArrayList[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N + 1; i++){
            times[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < C; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            inDegree[b]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 1; i < N+1; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(Node next : adj[now]){
                if(--inDegree[next.v] == 0){
                    q.add(next.v);
                }
                times[next.v] = Math.max(times[next.v], times[now] + next.e);
            }

        }

        for(int i = 1; i < N+1; i++){
            sb.append(times[i]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static class Node{
        int v, e;

        public Node(int v, int e){
            this.v = v;
            this.e = e;
        }

    }

}