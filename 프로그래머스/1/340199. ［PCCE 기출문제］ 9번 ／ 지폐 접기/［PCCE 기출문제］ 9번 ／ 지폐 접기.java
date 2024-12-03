class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int max = Math.max(wallet[0], wallet[1]);
        int min = Math.min(wallet[0], wallet[1]);
        
        while(true){
            int bill_max = Math.max(bill[0], bill[1]);
            int bill_min = Math.min(bill[0], bill[1]);
            
            if(bill_max <= max && bill_min <= min){
                break;
            }
            
            answer++;
            bill[0] = bill_max / 2;
            bill[1] = bill_min;
        }
        
        return answer;
    }
}