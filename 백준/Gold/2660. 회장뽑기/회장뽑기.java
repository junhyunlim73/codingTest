import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] friends;
    static ArrayList<Integer>[] adj;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static HashMap<Integer, ArrayList<Integer>> map;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        visited = new boolean[N+1][N+1];
        friends = new int[N+1][N+1];
        adj = new ArrayList[N+1];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(v == -1 || e == -1){
                break;
            }

            adj[v].add(e);
            adj[e].add(v);
        }

        for(int i = 1; i < N+1; i++){
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i][i] = true;
            int max = 0;

            while(!q.isEmpty()){
                int cur = q.poll();

                for(int d : adj[cur]){
                    if(!visited[i][d]){
                        q.add(d);
                        visited[i][d] = true;
                        friends[i][d] = friends[i][cur] + 1;
                        max = Math.max(max, friends[i][d]);
                    }
                }
            }

            min = Math.min(min, max);

            map.putIfAbsent(max, new ArrayList<>());
            map.get(max).add(i);
        }

        ArrayList<Integer> ans = map.get(min);
        Collections.sort(ans);

        System.out.println(min + " " + ans.size());

        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }

        br.close();
    }
}