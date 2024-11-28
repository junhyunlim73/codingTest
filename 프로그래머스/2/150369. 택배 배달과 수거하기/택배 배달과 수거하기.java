class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d = deliveries.length - 1;
        int p = pickups.length - 1;
        
        
        int pt;
        
        while(d >= 0 || p >= 0){
            while (d >= 0 && deliveries[d] == 0) d--;
            while (p >= 0 && pickups[p] == 0) p--;
            int maxDistance = Math.max(d, p) + 1;
            
            answer += maxDistance * 2; 

            int currentCap = cap;
            
            while (d >= 0 && currentCap > 0) {
                if (deliveries[d] <= currentCap) {
                    currentCap -= deliveries[d];
                    deliveries[d--] = 0;
                } else {
                    deliveries[d] -= currentCap;
                    currentCap = 0;
                }
            }

            currentCap = cap;
            while (p >= 0 && currentCap > 0) {
                if (pickups[p] <= currentCap) {
                    currentCap -= pickups[p];
                    pickups[p--] = 0;
                } else {
                    pickups[p] -= currentCap;
                    currentCap = 0;
                }
            }
            
        }
        
        return answer;
    }
    
}