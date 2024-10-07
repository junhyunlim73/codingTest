import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] visited;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        Arrays.fill(visited, 100001);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(N);
        visited[N] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if((now * 2) <= 100000 && (visited[now] < visited[now * 2])){
                visited[now*2] = visited[now];
                q.addFirst(now*2);
            }

            if((now + 1) <= 100000 && ((visited[now] + 1) < visited[now+1])){
                visited[now+1] = visited[now] + 1;
                q.add(now+1);
            }

            if((now - 1) >= 0 &&  (visited[now] + 1) < visited[now-1]){
                visited[now-1] = visited[now] + 1;
                q.add(now-1);
            }

        }

        System.out.println(visited[K]);
        br.close();
    }

}