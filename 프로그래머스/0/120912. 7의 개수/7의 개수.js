function solution(array) {
    var answer = 0;
    
    for(let a of array){
        let arr = String(a).split('')
        answer += count(arr);
    }
    
    return answer;
}

function count(arr){
    cnt = 0
    for(let n of arr){
        if(n === '7')
            cnt += 1
    }
    
    return cnt;
}