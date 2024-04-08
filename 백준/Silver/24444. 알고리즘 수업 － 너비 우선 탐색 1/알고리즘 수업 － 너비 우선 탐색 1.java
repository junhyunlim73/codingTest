import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] deep;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        deep = new int[N+1];
        for(int i = 1; i < N+1; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[v].add(e);
            graph[e].add(v);
        }
        for(int i = 1; i < N+1; i++)
            Collections.sort(graph[i]);
        BFS(r);
        for(int i = 1; i < N+1; i++)
            System.out.println(deep[i]);
        br.close();
    }

    private static void BFS(int r){
        Queue<Integer> queue = new LinkedList<>();
        visited[r] = true;
        queue.add(r);
        int cnt = 1;
        deep[r] = cnt;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i : graph[now]){
                if(!visited[i]){
                    visited[i] = true;
                    deep[i] = ++cnt;
                    queue.add(i);
                }
            }
        }
    }
}