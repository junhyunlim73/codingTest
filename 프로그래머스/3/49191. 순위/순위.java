import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        ArrayList<Integer>[] winners = new ArrayList[n+1];
        ArrayList<Integer>[] losers = new ArrayList[n+1];
        
        for(int i = 1; i < n + 1; i++){
            winners[i] = new ArrayList<>();
            losers[i] = new ArrayList<>();
        }
        
        for(int[] result : results){
            int winner = result[0];
            int loser = result[1];
            
            winners[winner].add(loser);
            losers[loser].add(winner);
        }
        
        for(int i = 1; i < n + 1; i++){
            int cnt = 0;
            visited = new boolean[n+1];
            visited[i] = true;
            cnt += bfs(i, winners);
            cnt += bfs(i, losers);
            
            if(cnt == n - 1)
                answer++;
            
        }
        
        return answer;
    }
    
    private static int bfs(int start, ArrayList<Integer>[] adj){
        int cnt = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
            
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int d : adj[now]){
                if(!visited[d]){
                    visited[d] = true;
                    q.add(d);
                    cnt++;
                }
            }
            
        }
        
        return cnt;
    }
    
}