class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int dp[][] = new int[n][];
        int d = 0;
        
        for(int i = 0; i < n; i++){
            dp[i] = new int[i+1];
        }
        
        int r = 0;
        int c = 0;
        int num = 1;
        int total = total(n);
        
        answer = new int[total];
        
        for(int i = 1; i < total + 1; i++){
            if(dp[r][c] == 0){
                dp[r][c] = i;
            }
            
            if(d == 0){
                int nr = r + 1;
                
                if(nr >= n || dp[nr][c] != 0){
                    d = 1;
                }
                    
                else
                    r = nr;
            }
            
            if(d == 1){
                int nc = c + 1;
                int len = dp[r].length;
                
                if(nc >= len || dp[r][nc] != 0){
                   d = 2;
                }
                
                else
                    c = nc;
                
            }
            
            if(d == 2){
                int nr = r - 1;
                int nc = c - 1;
                
                if(nr < 0 || nc < 0 || dp[nr][nc] != 0){
                    d = 0;
                    
                    nr = r + 1;
                
                    if(nr >= n || dp[nr][c] != 0){
                        d = 1;
                    }
                    
                    else
                        r = nr;
                    
                }
                    
                else{
                    r = nr;
                    c = nc;
                }  
            }
            
        }
        
        int idx = 0;
        
        for(int j = 0; j < n; j++){
            for(int k = 0; k < dp[j].length; k++){
                answer[idx++] = dp[j][k];
            }
        }
        
        return answer;
    }
    
    private int total(int n){
        return (1 + n) * n / 2;
    }
}