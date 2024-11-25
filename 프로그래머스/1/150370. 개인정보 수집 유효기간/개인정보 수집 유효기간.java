import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String term : terms){
            String[] temps = term.split(" ");
            int mon = Integer.parseInt(temps[1]);
            
            map.put(temps[0], mon);
        }
        
        String[] dates = today.split("\\.");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        
        int idx = 1;
        
        for(String privacy : privacies){
            String[] temps = privacy.split(" ");
            String[] date = temps[0].split("\\.");
            int duration = map.get(temps[1]);
            
            int y = Integer.parseInt(date[0]);
            int m = Integer.parseInt(date[1]);
            int d = Integer.parseInt(date[2]);
            
            m += (duration % 12);
            
            if(duration >= 12){
               y += (duration / 12); 
            }
            
            if(m > 12){
               y += (m / 12);
               m %= 12;
            }
            
            d--;
            
            if(d == 0){
                m -= 1;
                d = 28;
                
                if(m == 0){
                    y--;
                    m = 12;
                }
                
            }
            
            if(year > y){
                answer.add(idx);
            }else if((year == y) && (month > m)){
                answer.add(idx);
            }else if((year == y) && (month == m) && (day > d))
                answer.add(idx);
            
            idx++;
        }
         
        return answer;
    }
}