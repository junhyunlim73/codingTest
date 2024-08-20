import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int N;
    static PriorityQueue<Edge> minHeap;
    static long result;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N  = Integer.parseInt(br.readLine());
        parents = new int[N];
        minHeap = new PriorityQueue<Edge>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            parents[i] = i;
            for(int j = 0; j < N; j++){
                int weight = Integer.parseInt(st.nextToken());
                if(weight == 0)
                    continue;

                if(i < j)
                    minHeap.add(new Edge(i, j, weight));
            }
        }

        while (!minHeap.isEmpty()){
            Edge e = minHeap.poll();

            int startRoot = Find(e.start);
            int endRoot = Find(e.end);

            if(startRoot != endRoot){
                Union(startRoot, endRoot);
                result += e.weight;
                cnt++;
            }

            if(cnt == N - 1)
                break;
        }

        System.out.println(result);
        br.close();
    }

    static private int Find(int a){
        if(parents[a] == a) return a;
        return parents[a] = Find(parents[a]);
    }

    static private void Union(int a, int b){
        a = Find(a);
        b = Find(b);

        if(a < b)
            parents[b] = a;
        else
            parents[a] = b;
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

}