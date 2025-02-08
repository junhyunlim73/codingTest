import java.util.*;

class Solution {
    static int[][] dp;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};
    static int mod = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp = new int[n+1][m+1];
        
        for(int i = 1; i < n+1; i++){
            Arrays.fill(dp[i], -1);
        }
        
        for(int[] puddle : puddles){
            dp[puddle[1]][puddle[0]] = -2;
        }
        
        answer += dfs(1, 1, n, m);
        
        return answer;
    }
    
    private int dfs(int r, int c, int n, int m){
        if(r == n && c == m){
            return 1;
        }
        
        if(dp[r][c] != -1)
            return dp[r][c];
        
        dp[r][c] = 0;
        
        for(int i = 0; i < 2; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr > n || nc > m)
                continue;
            
            if(dp[nr][nc] == -2)
                continue;
            
            dp[r][c] = ((dp[r][c]  % mod) + (dfs(nr, nc, n, m) % mod)) % mod;
        }
        
        return dp[r][c];
    }
    
}