import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] Dvisited;
    static boolean[] Bvisited;
    static int N, M;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        Dvisited = new boolean[N+1];
        Bvisited = new boolean[N+1];
        for(int i = 1; i < N+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[v].add(e);
            graph[e].add(v);
        }
        for(int i = 1; i < N+1; i++){
            Collections.sort(graph[i]);

        }
        DFS(r);
        System.out.println();
        BFS(r);
        br.close();
    }

    private static void DFS(int r){
        if(Dvisited[r]){
            return;
        }
        Dvisited[r] = true;
        System.out.print(r + " ");
        for(int num : graph[r]){
            if(!Dvisited[num]){
                DFS(num);
            }
        }
    }

    private static void BFS(int r){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r);
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(!Bvisited[now]){
                System.out.print(now + " ");
                Bvisited[now] = true;
                for(int i : graph[now]){
                    queue.offer(i);
                }
            }
        }
    }
}