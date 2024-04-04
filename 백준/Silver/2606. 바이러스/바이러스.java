import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        graph = new ArrayList[v+1];
        visited = new boolean[v+1];
        for(int i = 1; i <= v; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < e; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph[n].add(m);
            graph[m].add(n);
        }
        DFS(1);
        System.out.println(cnt);
        br.close();
    }

    private static void DFS(int p){
        if(visited[p])
            return;
        visited[p] = true;
        for(int i : graph[p]){
            if(!visited[i]){
                cnt++;
                DFS(i);
            }
        }
    }
}