class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        int size = arr[0].length;
        ConAndDiv(arr, 0, 0, size);
        
        return answer;
    }
    
    private void ConAndDiv(int[][] arr, int i, int j, int size){
        int target = arr[i][j];
        
        if(isCheck(arr, i, j, size, target)){
            answer[target]++;
        }else{
            int Dsize = size / 2;
            ConAndDiv(arr, i, j, Dsize);
            ConAndDiv(arr, i, j + Dsize, Dsize);
            ConAndDiv(arr, i + Dsize, j, Dsize);
            ConAndDiv(arr, i + Dsize, j + Dsize, Dsize);
        }
        
    }
    
    private boolean isCheck(int[][] arr, int r, int c, int size, int target){
        int len1 = r + size;
        int len2 = c + size;
        
        for(int i = r; i < len1; i++){
            for(int j = c; j < len2; j++){
                if(target != arr[i][j])
                    return false;
            }
        }
        
        return true;
    }
    
}