function solution(number) {
    var answer = 0;
    
    for(let num of number){
        answer += Number(num);
    }
    
    return answer % 9;
}