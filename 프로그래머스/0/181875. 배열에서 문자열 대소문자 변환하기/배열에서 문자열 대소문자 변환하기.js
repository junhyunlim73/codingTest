function solution(strArr) {
    var answer = [];
    
    for(let idx in strArr){
        answer.push(idx % 2 === 0 ? strArr[idx].toLowerCase() : strArr[idx].toUpperCase())
    }
    
    return answer;
}