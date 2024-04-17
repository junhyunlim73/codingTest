import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V, E, r;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static HashMap<Integer, Integer> track;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        adj = new ArrayList[V+1];
        visited = new boolean[V+1];
        track = new HashMap<>();
        for(int i = 1; i < V+1; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start].add(end);
            adj[end].add(start);
        }
        for(int i = 1; i < V+1; i++){
            Collections.sort(adj[i]);
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>(Arrays.asList(r));
        int num =1;
        while(!stack.isEmpty()){
            int cur = stack.removeLast();
            if(!visited[cur]){
                visited[cur] = true;
                track.put(cur, num++);
            }
            for(int d : adj[cur]){
                if(!visited[d])
                    stack.addLast(d);
            }
        }
        for(int i = 1; i < V+1; i++){
            if(!track.containsKey(i)){
                sb.append(0 + "\n");
            }else{
                sb.append(track.get(i) + "\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}