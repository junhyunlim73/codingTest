import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int N, M;
    static int[] cnts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[101];
        adj = new ArrayList[101];
        cnts = new int[101];

        for(int i = 0; i < 101; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[v].add(e);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[v].add(e);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur == 100)
                break;

            for(int i = 1; i < 7; i++){
                int next = cur + i;

                if(next > 100)
                    continue;

                if(!visited[next]){
                    visited[next] = true;
                    cnts[next] = cnts[cur] + 1;

                    if(adj[next].size() > 0){
                        int num = adj[next].get(0);
                        if(!visited[num]){
                            q.add(num);
                            visited[num] = true;
                            cnts[num] = cnts[next];
                        }
                    }else{
                        q.add(next);
                    }
                }
            }
        }

        System.out.println(cnts[100]);
        br.close();
    }
}