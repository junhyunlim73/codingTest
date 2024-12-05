import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        int idx = 0;
        
        HashMap<String, String> park = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Car> list = new ArrayList<>();
        
        for(String record : records){
            String[] temps = record.split(" ");
            
            if(temps[2].equals("IN")){
                park.put(temps[1], temps[0]);
            }else if(temps[2].equals("OUT")){
                int preTime = converTotime(park.get(temps[1]));
                int curTime = converTotime(temps[0]);
                int time = curTime - preTime;
                map.put(temps[1], map.getOrDefault(temps[1], 0) + time);
                park.remove(temps[1]);
            }
            
        }
        
        for(String key : park.keySet()){
            int preTime = converTotime(park.get(key));
            int curTime = converTotime("23:59");
            int time = curTime - preTime;
            map.put(key, map.getOrDefault(key, 0) + time);
        }
        
        for(String key : map.keySet()){
            int num = Integer.parseInt(key);
            int time = map.get(key);
            int cost = 0;
            
            if(time <= fees[0]){
                cost = fees[1];
            }else{
                int p = 0;
                if((time - fees[0]) % fees[2] == 0){
                    p = (time - fees[0]) / fees[2];
                }else{
                   p = (time - fees[0]) / fees[2] + 1; 
                }
 
                cost = fees[1] + p * fees[3];
            }
            
            list.add(new Car(num, cost));
        }
        
        Collections.sort(list);
        answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            int cost = list.get(i).cost;
            answer[i] = cost;
        }
        
        return answer;
    }
    
    private int converTotime(String time){
        String[] temps = time.split(":");
        return Integer.parseInt(temps[0]) * 60 + Integer.parseInt(temps[1]);
    }
    
    static class Car implements Comparable<Car>{
        int num;
        int cost;
        
        public Car(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
        
        public int compareTo(Car o){
            return Integer.compare(this.num, o.num);
        }
    }
    
}