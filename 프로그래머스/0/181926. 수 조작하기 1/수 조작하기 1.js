function solution(n, control) {
    var answer = n;
    
    for(let str of control){
        if(str === "w")
            answer += 1;
        else if(str === "s")
            answer -= 1;
        else if(str === "d")
            answer += 10;
        else
            answer -= 10;
    }
    
    return answer;
}