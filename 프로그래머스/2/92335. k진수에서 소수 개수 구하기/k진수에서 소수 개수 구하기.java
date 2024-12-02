class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
        String nums = "";
        
        while(n > 0){
            int num = n % k;
            String str = String.valueOf(num);
            nums = str + nums;
            n /= k;
        }
        
        String[] temps = nums.split("0");
        
        for(String temp : temps){
            if(temp.equals(""))
                continue;
            
            long num = Long.parseLong(temp);
            
            if(isPrime(num))
                answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(long num){
        if(num < 2)
            return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++){
                if(num % i == 0)
                    return false;
            
        }
    
        return true;
    }
    
}