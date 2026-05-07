function solution(n) {
    var answer = 1;
    
    let f = 1;
    
    while(true){
        f *= answer;
        
        if(n < f)
            return (answer - 1)
        
        answer++
    }
    
    return answer;
}