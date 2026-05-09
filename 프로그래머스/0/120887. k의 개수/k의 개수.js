function solution(i, j, k) {
    var answer = 0;
    
    for(let m = i; m < (j+1); m++){
        arr = String(m).split('');
        
        for(let n of arr){
            if(n == k)
                answer++;
        }
        
    }
    
    return answer;
}