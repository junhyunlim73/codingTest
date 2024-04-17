import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int V, E, r;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V+1];
        visited = new boolean[V+1];
        for(int i = 0; i < V + 1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        for(int i= 1; i < V+1; i++){
            Collections.sort(graph[i]);
        }
        DFS(r);
        sb.append("\n");
        visited = new boolean[V+1];
        Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(r));
        while(!queue.isEmpty()){
            int cur = queue.remove();
            if(!visited[cur]){
                visited[cur] = true;
                sb.append(cur + " ");
            }
            for(int d : graph[cur]){
                if(!visited[d])
                    queue.add(d);
            }
        }
        System.out.println(sb.toString());
        br.close();
    }

    static void DFS(int r){
        if(visited[r])
            return;
        visited[r] = true;
        sb.append(r + " ");
        for(int d : graph[r]){
            if(!visited[d])
                DFS(d);
        }
    }
}