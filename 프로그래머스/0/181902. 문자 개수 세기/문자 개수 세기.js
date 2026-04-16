function solution(my_string) {
    var answer = Array(52).fill(0);
    let idx = 0
    
    for(let s of my_string){
        if(isAllLowerCase(s))
            idx = s.charCodeAt(0)  - 71
        else
            idx = s.charCodeAt(0)  - 65
        answer[idx] += 1
    }
    
    return answer;
}

function isAllLowerCase(str) {
    return str === str.toLowerCase();
}
