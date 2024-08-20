import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static PriorityQueue<Edge> pq;
    static int[] parents;
    static int result;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parents = new int[V+1];
        pq = new PriorityQueue<Edge>();

        for(int i = 1 ; i < V + 1; i++){
            parents[i] = i;
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Edge(start, end, weight));
        }

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int startRoot = Find(e.start);
            int endRoot = Find(e.end);

            if(startRoot != endRoot){
                union(startRoot, endRoot);
                result += e.weight;
                cnt++;
            }

            if(cnt == V - 1)
                break;
        }

        System.out.println(result);
        br.close();
    }

    static int Find(int a){
        if(parents[a] == a)
            return a;
        return parents[a] = Find(parents[a]);
    }

    static private void union(int a, int b){
        a = Find(a);
        b = Find(b);

        if(a < b)
            parents[b] = a;
        else
            parents[a] = b;
    }

    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}