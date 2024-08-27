import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] inDegree;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        inDegree = new int[N + 1];
        cnt = N;

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());
            int[] arr = new int[size];

            for(int j = 0; j < size; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1; j < size; j++){
                adj[arr[j-1]].add(arr[j]);
                inDegree[arr[j]]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append("\n");
            cnt--;

            for(int num : adj[cur]){
                if(--inDegree[num] == 0){
                    q.add(num);
                }
            }

        }

        System.out.print(cnt == 0 ? sb.toString() : 0);
        br.close();
    }

}