import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] paint = new int[n+1];
        
        for(int e : section)
            paint[e] = -1;
        
        for(int i = 1; i < n + 1; i++){
            if(paint[i] == -1){
                int len = Math.min(n + 1, i + m);
                
                for(int j = i; j < len; j++){
                    if(paint[j] == -1)
                        paint[j] = 0;
                }
                
                answer++;
            }
            
        }
            
        return answer;
    }
}