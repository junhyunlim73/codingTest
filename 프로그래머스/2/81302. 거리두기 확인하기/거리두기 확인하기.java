import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++){
            answer[i] = isOk(places[i]);
        }
        
        return answer;
    }
    
    private int isOk(String[] place){
        char[][] board = new char[5][5];
        boolean flag = false;
        
        for(int i = 0; i < 5; i++){
            char[] ch = place[i].toCharArray();
            for(int j = 0; j < 5; j++){
                board[i][j] = ch[j];
            }
            
        }
        
        for(int i = 0; i < 5; i++){
            if(flag)
                break;
            
            for(int j = 0; j < 5; j++){
                if(board[i][j] == 'P'){
                    flag = dfs(board, i, j);
                }
                
                if(flag)
                    break;
            }
        }
        
        if(flag)
            return 0;
        
        return 1;
    }
    
    private static boolean dfs(char[][] board, int i, int j){
        boolean[][] visited = new boolean[5][5];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j, 0});
        visited[i][j] = true;
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];
            int dist = arr[2];
            
            for(int k = 0; k < 4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
                
                if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5)
                    continue;
                
                if(!visited[nr][nc] && board[nr][nc] == 'O' && dist < 2){
                    q.add(new int[]{nr, nc, dist + 1});
                    visited[nr][nc] = true;
                }else if(!visited[nr][nc] && board[nr][nc] == 'P' && dist < 2){
                    return true;
                }
                
            }
            
        }
        
        return false;
    }
    
}