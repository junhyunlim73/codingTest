import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int r, c;
    static char[][] board;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        r = storage.length;
        c = storage[0].length();
        HashSet<Character> set = new HashSet<>();
        
        board = new char[r+2][c+2];
        
        for(int i = 0; i < (r+2); i++){
            Arrays.fill(board[i], '0');
        }
        
        for(int i = 1; i < (r + 1); i++){
            char[] arr = storage[i-1].toCharArray();
            for(int j = 1; j < (c + 1); j++){
                board[i][j] = arr[j-1];
                set.add(board[i][j]);
            }
        }
        
        for(String request : requests){
            int len = request.length();
            char target = request.charAt(0);
            
            if(!set.contains(target))
                continue;
            
            if(len == 1){
                bfs(target);
            }else{
               for(int i = 1; i < (r+1); i++){
                   for(int j = 1; j < (c+1); j++){
                       if(board[i][j] == target)
                           board[i][j] = '0';
                   }
               } 
            }
            
        }
        
        for(int i = 1; i < (r+1); i++){
            for(int j = 1; j < (c+1); j++){
                if(board[i][j] != '0')
                    answer++;
            }
        }
        
        return answer;
    }
    
    private static void bfs(char target){
        visited = new boolean[r+2][c+2];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                
                if(nr < 0 || nc < 0 || nr >= (r+2) || nc >= (c+2))
                    continue;
                
                if(visited[nr][nc])
                    continue;
                
                if(board[nr][nc] == '0'){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }else if(board[nr][nc] == target){
                    visited[nr][nc] = true;
                    board[nr][nc] = '0';
                }
                
            }
            
        }
        
    }
    
}