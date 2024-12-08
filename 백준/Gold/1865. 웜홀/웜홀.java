import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static long[] dist;
    static List<Edge> graph;
    static long INF = Long.MAX_VALUE;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            boolean flag = false;
            graph = new LinkedList<>();
            dist = new long[N + 1];

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph.add(new Edge(a, b, c));
                graph.add(new Edge(b, a, c));
            }

            for(int i = 0; i < W; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph.add(new Edge(a, b, -c));
            }

            flag = BellMan(N);

            if(flag){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
        br.close();
    }

    private static boolean BellMan(int N){
        for(int i = 1; i <= N; i++){
            Arrays.fill(dist, INF);
            dist[i] = 0;
            boolean isChecked = false;

            for(int j = 1; j <= N; j++){
                isChecked = false;

                for(Edge e : graph){
                    if(dist[e.start] != INF && dist[e.start] + e.weight < dist[e.end]){
                        dist[e.end] = dist[e.start] + e.weight;
                        isChecked = true;

                        if(j == N){
                            return true;
                        }

                    }
                }

                if(!isChecked)
                    break;
            }

        }

        return false;
    }

    static class Edge{
        int start, end, weight;

        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

}
