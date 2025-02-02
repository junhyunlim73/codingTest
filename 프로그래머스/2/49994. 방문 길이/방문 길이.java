import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        int x = 0, y = 0;
        
        char[] chars = dirs.toCharArray();
        
        for(char ch : chars){
            int nx = 0, ny = 0;
            int preX = x, preY = y;
            
            if(ch == 'U'){
                nx = x;
                ny = y + 1;
            }else if(ch == 'D'){
                nx = x;
                ny = y - 1;
            }else if(ch == 'R'){
                nx = x + 1;
                ny = y;
            }else if(ch == 'L'){
                nx = x - 1;
                ny = y;
            }
            
            if(nx < -5 || ny < -5 || nx > 5 || ny > 5)
                continue;
            
            PriorityQueue<Cordinate> q = new PriorityQueue<>();
            q.add(new Cordinate(preX, preY));
            q.add(new Cordinate(nx, ny));
            
            String str = "";
            
            while(!q.isEmpty()){
                Cordinate now = q.poll();
                str += now.x + ", " + now.y;
            }
            
            if(!set.contains(str)){
                answer++;
                set.add(str);
            }
                
            x = nx;
            y = ny;
        }
        
        return answer;
    }
    
    static class Cordinate implements Comparable<Cordinate>{
        int x, y;
        
        public Cordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Cordinate o){
            if(this.x == o.x){
                return Integer.compare(this.y, o.y);
            }
            
            return Integer.compare(this.x, o.x);
        }
        
    }
    
}