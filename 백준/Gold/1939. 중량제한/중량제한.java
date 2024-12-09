
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] adj;
    static int N, M;
    static int st_idx, end_idx;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b,c));
            adj[b].add(new Node(a,c));
            end_idx = Math.max(end_idx, c);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        while(st_idx <= end_idx){
            int mid = (st_idx + end_idx) / 2;
            ArrayDeque<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[N+1];
            boolean flag = false;

            visited[start] = true;

            q.add(start);

            while (!q.isEmpty()){
                int now = q.poll();

                if(now == end){
                    max = Math.max(max, mid);
                    flag = true;
                    break;
                }

                for(Node next : adj[now]){
                    if(!visited[next.v] && mid <= next.weight){
                        q.add(next.v);
                        visited[next.v] = true;
                    }
                }

            }

            if(flag)
                st_idx = mid + 1;
            else
                end_idx = mid - 1;
        }

        System.out.println(max);
        br.close();
    }

    static class Node {
        int v, weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
        
    }

}
