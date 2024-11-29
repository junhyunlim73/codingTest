import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        for(String operation : operations){
            String[] temps = operation.split(" ");
            int num = Integer.parseInt(temps[1]);
            
            if(temps[0].equals("I")){
                max.add(num);
                min.add(num);
            }else if(temps[0].equals("D")){
                if(num == 1 && !max.isEmpty()){
                    int maxNum = max.poll();
                    min.remove(maxNum);
                }else if(num == -1 && !min.isEmpty()){
                    int minNum = min.poll();
                    max.remove(minNum);
                }
            }  
                
        }
            
        if(!max.isEmpty() && !min.isEmpty()){
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        
        return answer;
    }
}