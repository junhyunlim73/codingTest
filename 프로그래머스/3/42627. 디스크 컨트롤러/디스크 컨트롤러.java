import java.util.*;

class Solution {
    static Job job;
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        int[] arr = new int[len];
        int cur = 0;
        int complete = 0;
        
        boolean[] visited = new boolean[len];
        PriorityQueue<Job> q = new PriorityQueue<>();
        
        while(complete < len){
            boolean flag = false;
            
            for(int i = 0; i < len; i++){
               if(!visited[i] && jobs[i][0] <= cur){
                    q.add(new Job(i, jobs[i][0], jobs[i][1]));
                    visited[i] = true;
                } 
            }
            
            if(!q.isEmpty() && job == null){
                job = q.poll();
                cur += job.workTime;
                arr[complete] = cur - job.time;
                complete++;
                flag = true;
                job = null;
            }
            
            if(!flag)
                cur++;
        }
        
        for(int t : arr){
           answer += t;
        }
        
        answer /= len;
        
        return answer;
    }
    
    static class Job implements Comparable<Job>{ 
        int num, time, workTime;
        
        public Job(int num, int time, int workTime){
            this.num = num;
            this.time = time;
            this.workTime = workTime;
        }
        
        public int compareTo(Job o){
            if(workTime == o.workTime){
                if(time == o.time){
                    return Integer.compare(num, o.num);
                }
                return Integer.compare(time, o.time);
            }
            return Integer.compare(workTime, o.workTime);
        }
    }
}