import java.util.*;

class Solution {
    
    public int solution(int[] A, int[] B) {
        int len = A.length;
        int answer = 0;
        int idx = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < len; i++){
            for(int j = idx; j < len; j++){
                if(A[i] < B[j]){
                    answer++;
                    idx = j+1;
                    break;
                }
            }
        }
        
        return answer;
    }
    
}