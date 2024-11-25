class Solution {
    static int[] sel;
    static int len;
    static int max, result;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        sel = new int[emoticons.length];
        len = emoticons.length;
        perm(0, users, emoticons);
        
        answer[0] = max;
        answer[1] = result;
        return answer;
    }
    
    private void perm(int depth, int[][] users, int[] emoticons){
        if(depth == len){
            int pre = 0;
            int num = 0;
            
            for(int i = 0; i < users.length; i++){
                int discount = users[i][0];
                int total = users[i][1];
                int sum = 0;
                
                for(int j = 0; j < len; j++){
                    if(sel[j] >= discount){
                        sum += emoticons[j] * ((100 - sel[j]) * 0.01);
                    }
                }
                
                if(sum < total){
                    pre += sum;
                }else{
                    num++;
                }
            }
            
            if(max < num){
                max = num;
                result = pre;
            }else if(max == num){
                if(result < pre){
                    result = pre;
                }
            }
            
            return;
        }
        
        for(int i = 10; i <= 40; i +=10){
            sel[depth] = i;
            perm(depth+1, users, emoticons);
        }
        
    }
    
}