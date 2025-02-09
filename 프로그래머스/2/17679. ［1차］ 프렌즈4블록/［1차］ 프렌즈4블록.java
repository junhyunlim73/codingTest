import java.util.*;

class Solution {
    static char[][] map;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean flag = false;
        map = new char[m][n];
        
        for(int i = 0; i < m; i++){
            char[] chs = board[i].toCharArray();
            for(int j = 0; j < n; j++){
                map[i][j] = chs[j];
            }
        }
        
        while(true){
            LinkedHashSet<int[]> set = new LinkedHashSet<>();
            
            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    char target = map[i][j];
                    
                    if(target == '0')
                        continue;
                    
                    if(isCheck(i, j, target)){
                        set.add(new int[]{i, j, i, j + 1, i + 1, j, i + 1, j + 1});
                    }
                    
                }
            }
            
            if(set.size() == 0){
                break;
            }else{
                for(int[] rc : set){
                    for(int i = 0; i < 8; i+=2){
                        int r = rc[i];
                        int c = rc[i+1];
                        map[r][c] = '0';
                        
                    }
                     
                }
                
                for(int i = m - 1; i >= 1; i--){
                    for(int j = 0; j < n; j++){
                        if(map[i][j] == '0')
                            move(i - 1, j);
                    }
                }
                
            }
            
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == '0')
                    answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isCheck(int r, int c, char target){
        if((map[r][c] == target) && (map[r][c+1] == target) && (map[r+1][c] == target) && (map[r+1][c+1] == target))
            return true;
        else
            return false;
    }
    
    private void move(int r, int c){
        int sR = r + 1;
        
        while(true){
            if(r < 0)
                break;
            
            if(map[r][c] != '0'){
                char temp = map[sR][c];
                map[sR][c] = map[r][c];
                map[r][c] = temp;
                break;
            }
            
            r--;
        }
    }
    
}