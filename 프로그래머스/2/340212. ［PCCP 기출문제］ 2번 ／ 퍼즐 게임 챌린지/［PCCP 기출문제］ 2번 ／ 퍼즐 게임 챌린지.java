class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        
        int start = 1;
        int end = 1;
        
        for(int i = 1; i < diffs.length; i++){
            end = Math.max(end, diffs[i]);
        }
        
        while(start <= end){
           long sum = times[0];
            int mid = (start + end) / 2;
            
            for(int i = 1; i < diffs.length; i++){
                int diff = diffs[i];
            
                if(diff <= mid){
                    sum += times[i];
                }else{
                    int num = diff - mid;
                    int pre = times[i-1];
                    sum += ((pre + times[i]) * num + times[i]);
                }
            
            }
            
            if(sum <= limit){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        
        return start;
    }
}