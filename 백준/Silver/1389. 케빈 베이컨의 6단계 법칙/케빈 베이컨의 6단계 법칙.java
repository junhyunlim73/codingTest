import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] routes;
    static ArrayList<Integer>[] adj;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<int[]> route  = new ArrayList<>();

        routes = new int[N+1][N+1];
        adj = new ArrayList[N+1];

        for(int i = 0; i < N+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            adj[B].add(A);
        }

        for(int i = 1; i <= N; i++){
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            int sum = 0;
            while(!q.isEmpty()){
                int cur = q.poll();

                for(int v : adj[cur]){
                    if(v != i && routes[i][v] == 0){
                        routes[i][v] = routes[i][cur] + 1;
                        q.add(v);
                        sum += routes[i][v];
                    }
                }
            }
            route.add(new int[]{i, sum});
        }

        Collections.sort(route, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
              if(a[1] == b[1])
                  return a[0] - b[0];
              return a[1] - b[1];
            }
        });

        System.out.println(route.get(0)[0]);
        br.close();
    }

}