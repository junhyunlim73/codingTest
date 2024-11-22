import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        ArrayDeque<Truck> q = new ArrayDeque<>();
        
        for(int i = 0; i < truck_weights.length; i++){
            q.add(new Truck(truck_weights[i], bridge_length));
        }
        
        ArrayList<Truck> list = new ArrayList<>();  
        
        while(!q.isEmpty() || !list.isEmpty()){
            answer++;
            
            if(list.isEmpty()){
                Truck now = q.poll();
                list.add(now);
            }else{
                for(int i = 0; i < list.size(); i++){
                    Truck truck = list.get(i);
                    int truck_weight = truck.weight;
                    int time = truck.time - 1;
                    
                    if(time == 0){
                        list.remove(i);
                        i--;
                        continue;
                    }
                        
                    list.set(i, new Truck(truck_weight, time));                    
                }
                
                int sum = 0;
                
                for(int i = 0; i < list.size(); i++){
                    sum += list.get(i).weight;
                }
                
                if(!q.isEmpty() && (sum + q.peek().weight) <= weight){
                    Truck truck = q.poll();
                    list.add(truck);
                }
            }
            
        }
        
        return answer;
    }
    
    static class Truck{
        int time, weight;
        
        public Truck(int weight, int time){
            this.weight = weight;
            this.time = time;
        }
    }
}