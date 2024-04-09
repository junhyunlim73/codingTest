import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> graph;
    static int n;
    static int cnt = -1;
    static int x;
    static int y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        graph = new HashMap<>();
        visited = new boolean[n+1];
        for(int i = 1; i < n + 1; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(v).add(e);
            graph.get(e).add(v);
        }
        DFS(x, 0);
        System.out.println(cnt);
        br.close();
    }

    private static void DFS(int r, int num){
        visited[r] = true;
        if(r == y){
            cnt = num;
        }
        for(int i : graph.get(r)){
            if(!visited[i]){
                DFS(i, num + 1);
            }
        }
    }
}