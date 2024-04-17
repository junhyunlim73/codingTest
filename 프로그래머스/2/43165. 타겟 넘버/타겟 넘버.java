class Solution {
    public int solution(int[] numbers, int target) {
        int cnt = 0;
        for(int i = 0; i < 1 << numbers.length; i++){
            int sum = 0;
            for(int j = 0; j < numbers.length; j++){
                if((i & (1 << j)) != 0){
                    sum += numbers[j];
                }else{
                    sum -= numbers[j];
                }
            }
            if(sum == target)
                cnt++;
        }
        return cnt;
    }
}