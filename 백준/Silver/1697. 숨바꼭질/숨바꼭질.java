import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] visited;
    static int time = 100000;
    static ArrayList<Integer>[] adjList;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        adjList = new ArrayList[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        while (!q.isEmpty()) {
            int cur = q.poll();

            adjList[cur] = new ArrayList<>();
            visited[cur] = true;

            if(cur - 1 >= 0 && !visited[cur - 1]){
                q.add(cur-1);
                adjList[cur].add(cur-1);
            }

            if((cur + 1) <= 100000 && !visited[cur + 1]){
                q.add(cur + 1);
                adjList[cur].add(cur+1);
            }

            if((cur * 2) <= 100000 && !visited[cur * 2]){
                q.add(cur * 2);
                adjList[cur].add(cur*2);
            }
        }

        DFS(N, 0);
        System.out.println(time);
        br.close();
    }

    static void DFS(int parent, int cnt) {
        if (parent == K) {
            time = Math.min(time, cnt);
            return;
        }

        if(time <= cnt){
            return;
        }

        for(int d : adjList[parent]){
            DFS(d, cnt+1);
        }
    }
}