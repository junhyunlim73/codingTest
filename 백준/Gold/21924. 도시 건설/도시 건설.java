import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int V, E;
    static int cnt;
    static long total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parents = new int[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        for(int i = 1; i <= V; i++){
            parents[i] = i;
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end, cost));
            total += cost;
        }

        while(!pq.isEmpty()){
            Node node = pq.poll();

            int startRoot = find(node.start);
            int endRoot = find(node.end);

            if(startRoot != endRoot){
                union(startRoot, endRoot);
                total -= node.cost;
                cnt++;
            }

            if(cnt == V - 1)
                break;
        }
        
        System.out.println(cnt == V - 1 ? total : -1);
    }

    private static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b)
            parents[b] = a;
        else
            parents[a] = b;

    }

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Node n){
            return cost - n.cost;
        }
    }

}