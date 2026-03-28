function solution(a, b) {
    var answer = 0;
    let m1 = Math.min(a, b);
    let m2 = Math.max(a, b);
    
    for(let i = m1; i < m2 + 1; i++){
        answer += i;
    }
    
    return answer;
}