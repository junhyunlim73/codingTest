function solution(num, total) {
    var answer = [];
    
    let j = Math.floor(num / 2)
    let n = 0
    
    if(num % 2 == 0)
        n = Math.floor(total / num) - j + 1;
    else
        n = Math.floor(total / num) - j;
    
    for(let i = 0; i < num; i++){
        answer.push(n + i)
    }
    

    
    
    return answer;
}