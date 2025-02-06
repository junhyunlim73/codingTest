import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o2, o1)
        );
        
        for(int work : works){
            q.add(work);
        }
        
        while(q.peek() != 0 && n > 0){
            n--;
            int num = q.poll() - 1;
            q.add(num);
        }
        
        while(!q.isEmpty()){
            answer += (int) Math.pow(q.poll(), 2);
        }
        
        return answer;
    }
}