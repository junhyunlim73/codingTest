import java.util.*;

class Solution {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        adj = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i = 1; i < n + 1; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            adj[a].add(b);
            adj[b].add(a);
        }
        
        return bfs(1);
    }
    
    private int bfs(int start){
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});
        visited[start] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int cur = now[0];
            int dist = now[1];
            
            if(max < dist){
                list.clear();
                max = dist;
                list.add(cur);
            }else if(max == dist){
                list.add(cur);
            }
            
            for(int d : adj[cur]){
                if(!visited[d]){
                    visited[d] = true;
                    q.add(new int[]{d, dist+1});
                }
            }
            
        }
        
        return list.size();
    }
    
}