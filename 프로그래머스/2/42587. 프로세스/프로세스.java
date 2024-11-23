import java.util.*;

class Solution {
    static int[] arr;
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int len = priorities.length;
        int idx = 0;
        int cnt = 1;
        boolean flag = false;
        arr = new int[len];
        
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        
        for(int priority : priorities){
            q.add(priority);
        }
        
        int target = q.peek();
        
        while(!flag){
            if((arr[idx] == 0) && (priorities[idx] == target)){
                arr[idx] = cnt++;
                q.poll();
                
                if(idx == location){
                    answer = arr[idx];
                    flag = true;
                }
                
                if(!q.isEmpty())
                    target = q.peek(); 
            }
            
            idx = (idx + 1) % len;
        }
        
        return answer;
    }
}