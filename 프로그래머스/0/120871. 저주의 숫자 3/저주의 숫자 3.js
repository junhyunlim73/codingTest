function solution(n) {
    var answer = 1;
    let idx = 1;
    
    while(idx !== n){
        if((answer % 3 !== 0) && !String(answer).includes('3')){
            idx++;
        }
        answer++;
    }
    
    while(true){
        if((answer % 3 !== 0) && !String(answer).includes('3')){
            break;
        }
        answer++;
    }
    
    return answer;
}