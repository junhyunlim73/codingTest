import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adj;
    static int[] truthP;
    static int[] parents;
    static int N, M, T;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        adj = new ArrayList[M];

        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        truthP = new int[T];

        for(int i = 0; i < T; i++){
            truthP[i] = Integer.parseInt(st.nextToken());
            parents[truthP[i]] = 0;
        }

        for(int i = 0; i < M; i++){
            adj[i]  = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            for(int j = 0; j < num; j++){
                adj[i].add(Integer.parseInt(st.nextToken()));
            }

            for(int j = 1; j < num; j++){
                union(adj[i].get(j-1), adj[i].get(j));
            }
        }

        for(int i = 0; i < M; i++){
            boolean found = false;

            for(int j = 0; j < adj[i].size(); j++){
                int p = find(adj[i].get(j));

                if(p == 0){
                    found = true;
                    break;
                }
            }

            if(!found){
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }

    private static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y){
        x= find(x);
        y= find(y);

        if(x < y)
            parents[y] = x;
        else
            parents[x] = y;
    }

}