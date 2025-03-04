import java.util.*;

class Solution {
    static ArrayList<Node>[] adj;
    static int[] dist;
    static int INF = 1_000_000_000;
    
    public int solution(int N, int[][] road, int K) {
        dist = new int[N+1];
        adj = new ArrayList[N+1];
        
        for(int i = 1; i < N + 1; i++){
            adj[i] = new ArrayList<>();
        }
        
        Arrays.fill(dist, INF);
        
        for(int i = 0; i < road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }
        
        int answer = dijkstra(1, K);

        return answer;
    }
    
    private int dijkstra(int start, int k){
        int cnt = 0;
        
        dist[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, dist[start]));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(dist[now.v] < now.cost)
                continue;
            
            if(now.cost <= k){
                cnt++;
            }
            
            for(Node next : adj[now.v]){
                int nextDist = next.cost + dist[now.v];
                
                if(nextDist < dist[next.v]){
                    dist[next.v] = nextDist;
                    q.add(new Node(next.v, dist[next.v]));
                }
                
            }
        }
        
        return cnt;
    }
    
    
    static class Node implements Comparable<Node>{
        int v, cost;
        
        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
        
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }
    
}