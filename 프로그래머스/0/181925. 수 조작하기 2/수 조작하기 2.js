function solution(numLog) {
    var answer = '';
    let pre = 0
    
    for(let i = 1; i < numLog.length; i++){
        pre = numLog[i] - numLog[i - 1];
        answer += getChar(pre)
    }
    
    return answer;
}

function getChar(num){
    if(num === 1){
        return 'w';
    }else if(num === -1){
        return 's';
    }else if(num === 10){
        return 'd';
    }else{
        return 'a';
    }
}