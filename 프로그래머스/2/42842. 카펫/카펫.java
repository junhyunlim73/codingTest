import java.util.*;

class Solution {
    static ArrayList<int[]> list;
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        list = new ArrayList<>();
        
        for(int i = 3; i <= Math.sqrt(total); i++){
            if(total % i == 0){
                int other = total / i;
                list.add(new int[]{other, i});
            }
        }
        
        for(int[] arr : list){
            int r = arr[0];
            int c = arr[1];
            int result = (r * 2) + ((c - 2) * 2);
            int remind = total - result;
            
            if((result == brown) && (remind == yellow)){
                answer[0] = r;
                answer[1] = c;
                break;
            }      
            
        }
        
        return answer;
    }
}